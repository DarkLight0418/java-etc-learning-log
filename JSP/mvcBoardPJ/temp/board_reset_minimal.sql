
-- ===========================================================
-- JSP MVC Board - Minimal Reset (content LONGTEXT only)
-- * Drops existing tables
-- * Recreates users, boards, posts
-- * Seeds a few sample rows
-- Target: MySQL 8+/MariaDB 10.4+
-- ===========================================================

SET NAMES utf8mb4;
SET SESSION sql_mode='STRICT_ALL_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
test_schemaboards
-- 2) Drop (safe order)
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS boards;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS = 1;

-- 3) Minimal tables
-- 3-1) users
CREATE TABLE users (
  email         VARCHAR(255)  NOT NULL,
  password_hash VARCHAR(255)  NOT NULL,
  nickname      VARCHAR(60)   NOT NULL,
  joined_at     DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3-2) boards
CREATE TABLE boards (
  board_id    INT          NOT NULL AUTO_INCREMENT,
  code        VARCHAR(30)  NOT NULL,     -- 예: QNA, FREE, NOTICE
  name        VARCHAR(100) NOT NULL,
  description VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (board_id),
  UNIQUE KEY uk_boards_code (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 3-3) posts (연습 최단구성: content LONGTEXT만)
CREATE TABLE posts (
  post_id      BIGINT        NOT NULL AUTO_INCREMENT,
  board_id     INT           NOT NULL,
  email        VARCHAR(255)  NOT NULL,      -- 작성자 (users.email)
  title        VARCHAR(200)  NOT NULL,
  content      LONGTEXT      NOT NULL,      -- 순수 텍스트 그대로 저장
  created_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at   DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (post_id),
  KEY idx_posts_board_created (board_id, created_at DESC),
  KEY idx_posts_author_created (email, created_at DESC),
  CONSTRAINT fk_posts_boards FOREIGN KEY (board_id) REFERENCES boards(board_id),
  CONSTRAINT fk_posts_users  FOREIGN KEY (email)     REFERENCES users(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4) Seed
INSERT INTO users (email, password_hash, nickname, joined_at) VALUES
  ('admin@example.com', UPPER(SHA2('test1234',256)), '관리자', '2025-07-20 09:10:00'),
  ('kim@example.com',   UPPER(SHA2('kim12345',256)), '김개발', '2025-07-22 12:00:00')
ON DUPLICATE KEY UPDATE nickname=VALUES(nickname);

INSERT INTO boards (code, name, description) VALUES
  ('QNA',   'Q&A',    '질문과 답변'),
  ('FREE',  '자유',   '자유 게시판'),
  ('NOTICE','공지',   '운영자 공지')
ON DUPLICATE KEY UPDATE name=VALUES(name), description=VALUES(description);

INSERT INTO posts (board_id, email, title, content, created_at) VALUES
  ((SELECT board_id FROM boards WHERE code='NOTICE'), 'admin@example.com',
   '환영합니다 🎉', '기초 게시판 초기화가 완료되었습니다.\n이 글은 content LONGTEXT로 저장되었습니다.', '2025-08-28 09:00:00'),
  ((SELECT board_id FROM boards WHERE code='QNA'), 'kim@example.com',
   'JDBC 연결이 안돼요', 'DataSource 설정 방법이 궁금합니다.\ncontext.xml과 web.xml 설정 예시가 필요해요.', '2025-08-29 10:15:00'),
  ((SELECT board_id FROM boards WHERE code='FREE'), 'kim@example.com',
   '첫 글 테스트', '안녕하세요! 반갑습니다.\n줄바꿈은 그대로 저장됩니다.', '2025-08-30 18:30:00');

-- 5) 앱에서 사용할 INSERT 패턴 (참고)
--   SELECT board_id FROM boards WHERE code=?;   -- 코드로 보드를 선택했다면 id를 먼저 얻으세요.
--   INSERT INTO posts (board_id, email, title, content) VALUES (?, ?, ?, ?);
-- created_at/updated_at은 DEFAULT로 자동 입력됩니다.

-- 끝.
