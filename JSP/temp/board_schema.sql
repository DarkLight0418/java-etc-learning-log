
-- 2-1) 사용자(회원) 테이블
--  - 교육용 간소화: 이메일을 기본키(PK)로 사용 (요청사항 반영)
--  - 실제 운영에선 surrogate key(숫자 PK) + email UNIQUE를 권장
CREATE TABLE IF NOT EXISTS users (
  email            VARCHAR(255)  NOT NULL,        -- PK (로그인 ID로 사용)
  password_hash    VARCHAR(255)  NOT NULL,        -- 패스워드 해시 (SHA2/Bcrypt 등)
  nickname         VARCHAR(60)   NOT NULL,
  is_admin         TINYINT(1)    NOT NULL DEFAULT 0,
  joined_at        DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  last_login_at    DATETIME               DEFAULT NULL,
  status           ENUM('ACTIVE','SUSPENDED') NOT NULL DEFAULT 'ACTIVE',
  PRIMARY KEY (email),
  KEY idx_users_joined (joined_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2-2) 게시판 마스터 테이블 (Q&A/지식나눔/자유/공지 등)
CREATE TABLE IF NOT EXISTS boards (
  board_id     INT           NOT NULL AUTO_INCREMENT,
  code         VARCHAR(30)   NOT NULL,  -- 예: 'QNA', 'KNOW', 'FREE', 'NOTICE'
  name         VARCHAR(100)  NOT NULL,  -- 한글 이름
  description  VARCHAR(255)           DEFAULT NULL,
  admin_only   TINYINT(1)    NOT NULL DEFAULT 0,  -- 공지 게시판 등 운영자만 작성
  created_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (board_id),
  UNIQUE KEY uk_boards_code (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2-3) 게시글 테이블
CREATE TABLE IF NOT EXISTS posts (
  post_id        BIGINT        NOT NULL AUTO_INCREMENT,
  board_id       INT           NOT NULL,
  author_email   VARCHAR(255)  NOT NULL,
  title          VARCHAR(200)  NOT NULL,
  content_html   LONGTEXT      NOT NULL,   -- HTML 본문
  created_at     DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at     DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  view_count     INT           NOT NULL DEFAULT 0,
  comment_count  INT           NOT NULL DEFAULT 0, -- 트리거나 배치로 동기화
  like_count     INT           NOT NULL DEFAULT 0,
  scrap_count    INT           NOT NULL DEFAULT 0,
  report_count   INT           NOT NULL DEFAULT 0,
  pinned         TINYINT(1)    NOT NULL DEFAULT 0, -- 상단 고정
  deleted        TINYINT(1)    NOT NULL DEFAULT 0, -- 소프트 삭제
  PRIMARY KEY (post_id),
  KEY idx_posts_board_created (board_id, pinned, created_at DESC),
  KEY idx_posts_author_created (author_email, created_at DESC),
  CONSTRAINT fk_posts_boards  FOREIGN KEY (board_id)     REFERENCES boards(board_id),
  CONSTRAINT fk_posts_users   FOREIGN KEY (author_email) REFERENCES users(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2-4) 댓글 테이블 (선택이지만 일반적으로 필요)
CREATE TABLE IF NOT EXISTS comments (
  comment_id    BIGINT        NOT NULL AUTO_INCREMENT,
  post_id       BIGINT        NOT NULL,
  author_email  VARCHAR(255)  NOT NULL,
  content       TEXT          NOT NULL,
  created_at    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted       TINYINT(1)    NOT NULL DEFAULT 0,
  PRIMARY KEY (comment_id),
  KEY idx_comments_post_created (post_id, created_at),
  CONSTRAINT fk_comments_posts FOREIGN KEY (post_id)      REFERENCES posts(post_id) ON DELETE CASCADE,
  CONSTRAINT fk_comments_users FOREIGN KEY (author_email) REFERENCES users(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2-5) 좋아요(추천) / 스크랩 (옵션)
CREATE TABLE IF NOT EXISTS post_likes (
  post_id     BIGINT        NOT NULL,
  user_email  VARCHAR(255)  NOT NULL,
  created_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (post_id, user_email),
  CONSTRAINT fk_likes_posts FOREIGN KEY (post_id)     REFERENCES posts(post_id) ON DELETE CASCADE,
  CONSTRAINT fk_likes_users FOREIGN KEY (user_email)  REFERENCES users(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS post_scraps (
  post_id     BIGINT        NOT NULL,
  user_email  VARCHAR(255)  NOT NULL,
  created_at  DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (post_id, user_email),
  CONSTRAINT fk_scraps_posts FOREIGN KEY (post_id)     REFERENCES posts(post_id) ON DELETE CASCADE,
  CONSTRAINT fk_scraps_users FOREIGN KEY (user_email)  REFERENCES users(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 2-6) 첨부파일 (옵션)
CREATE TABLE IF NOT EXISTS post_attachments (
  attachment_id BIGINT        NOT NULL AUTO_INCREMENT,
  post_id       BIGINT        NOT NULL,
  file_name     VARCHAR(255)  NOT NULL,
  file_path     VARCHAR(500)  NOT NULL, -- 저장 경로 (또는 S3 키 등)
  file_size     BIGINT        NOT NULL,
  content_type  VARCHAR(100)           DEFAULT NULL,
  created_at    DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (attachment_id),
  KEY idx_attach_post (post_id, created_at),
  CONSTRAINT fk_attach_posts FOREIGN KEY (post_id) REFERENCES posts(post_id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3) 트리거 (선택) : 댓글 수 자동 반영
DELIMITER //
CREATE TRIGGER trg_comments_ai AFTER INSERT ON comments
FOR EACH ROW
BEGIN
  UPDATE posts SET comment_count = comment_count + 1 WHERE post_id = NEW.post_id;
END//
CREATE TRIGGER trg_comments_ad AFTER DELETE ON comments
FOR EACH ROW
BEGIN
  UPDATE posts SET comment_count = GREATEST(comment_count - 1, 0) WHERE post_id = OLD.post_id;
END//
DELIMITER ;

-- 4) 뷰 (선택) : 계정 요약
CREATE OR REPLACE VIEW v_user_summary AS
SELECT
  u.email,
  u.nickname,
  u.joined_at,
  u.last_login_at,
  (SELECT COUNT(*) FROM posts    p WHERE p.author_email = u.email AND p.deleted = 0) AS post_count,
  (SELECT COUNT(*) FROM comments c WHERE c.author_email = u.email AND c.deleted = 0) AS comment_count
FROM users u;

-- 5) 샘플 데이터 (보드/유저/글)
INSERT INTO boards (code, name, description, admin_only) VALUES
  ('QNA',   'Q&A',        '질문과 답변',            0),
  ('KNOW',  '지식나눔',   '지식 공유 게시판',        0),
  ('FREE',  '자유',       '자유 주제 게시판',        0),
  ('NOTICE','공지',       '운영자 공지',             1)
ON DUPLICATE KEY UPDATE name=VALUES(name), description=VALUES(description), admin_only=VALUES(admin_only);

-- 교육용: SHA2로 간단 해시(운영에선 Bcrypt/Argon2 권장)
-- 비밀번호: test1234
INSERT INTO users (email, password_hash, nickname, is_admin)
VALUES ('admin@example.com', UPPER(SHA2('test1234', 256)), '관리자', 1)
ON DUPLICATE KEY UPDATE nickname='관리자', is_admin=1;

-- 게시글 샘플
INSERT INTO posts (board_id, author_email, title, content_html, pinned)
SELECT b.board_id, 'admin@example.com', '환영합니다 🎉', '<p>게시판 설치가 완료되었습니다.</p>', 1
FROM boards b WHERE b.code='NOTICE'
LIMIT 1;

-- 6) 페이지별 핵심 쿼리 예시
-- 6-1) [계정 정보 페이지] 로그인 사용자의 요약 + 최근 글/댓글
-- 사용자 요약
--   SELECT * FROM v_user_summary WHERE email = ?;
-- 최근 작성 글 5건
--   SELECT p.post_id, b.name AS board_name, p.title, p.created_at, p.view_count, p.comment_count
--   FROM posts p JOIN boards b ON p.board_id=b.board_id
--   WHERE p.author_email = ? AND p.deleted=0
--   ORDER BY p.created_at DESC LIMIT 5;
-- 최근 댓글 5건
--   SELECT c.comment_id, c.post_id, c.created_at, LEFT(c.content, 120) AS preview
--   FROM comments c WHERE c.author_email=? AND c.deleted=0
--   ORDER BY c.created_at DESC LIMIT 5;

-- 6-2) [게시판 글 목록] 페이징 (board_id=?)
--   SELECT p.post_id, p.title, u.nickname AS author, p.created_at, p.view_count, p.comment_count, p.pinned
--   FROM posts p
--     JOIN users u ON p.author_email = u.email
--   WHERE p.board_id=? AND p.deleted=0
--   ORDER BY p.pinned DESC, p.created_at DESC
--   LIMIT ? OFFSET ?;

-- 6-3) [게시글 상세] + 조회수 증가 (트랜잭션 내 권장)
--   UPDATE posts SET view_count = view_count + 1 WHERE post_id=?;
--   SELECT p.*, u.nickname AS author_nickname, b.name AS board_name
--   FROM posts p
--     JOIN users u ON p.author_email=u.email
--     JOIN boards b ON p.board_id=b.board_id
--   WHERE p.post_id=?;

-- 6-4) [로그인] 간단 SHA2 예시 (실서비스: Bcrypt/Argon2를 사용하세요)
--   SELECT 1
--   FROM users
--   WHERE email=? AND password_hash = UPPER(SHA2(?, 256)) AND status='ACTIVE';

-- 7) 인덱스 체크 리스트
--  - posts(board_id, pinned, created_at DESC): 목록/페이징
--  - posts(author_email, created_at DESC): 사용자별 최근 글
--  - comments(post_id, created_at): 상세 화면 댓글
--  - users(email) PK/로그인
--  - boards(code) UNIQUE

-- 끝.
