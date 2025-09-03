
-- ===========================================================
-- JSP MVC Board: Sample Data Seed
-- Run AFTER board_schema.sql
-- Target: MySQL 8+/MariaDB 10.4+
-- ===========================================================


-- 0) Resolve board ids to variables for convenience
SET @QNA    := (SELECT board_id FROM boards WHERE code='QNA');
SET @KNOW   := (SELECT board_id FROM boards WHERE code='KNOW');
SET @FREE   := (SELECT board_id FROM boards WHERE code='FREE');
SET @NOTICE := (SELECT board_id FROM boards WHERE code='NOTICE');

-- 1) Users (교육용: SHA2 해시 사용; 운영은 Bcrypt/Argon2 권장)
INSERT INTO users (email, password_hash, nickname, is_admin, joined_at, last_login_at, status) VALUES
  ('admin@example.com', UPPER(SHA2('test1234',256)), '관리자', 1, '2025-07-20 09:10:00', '2025-09-02 21:05:00', 'ACTIVE'),
  ('kim@example.com',   UPPER(SHA2('kim12345',256)), '김개발', 0, '2025-07-22 12:00:00', '2025-09-03 09:00:00', 'ACTIVE'),
  ('lee@example.com',   UPPER(SHA2('lee12345',256)), '이디버거', 0, '2025-07-25 08:30:00', '2025-09-02 08:55:00', 'ACTIVE'),
  ('park@example.com',  UPPER(SHA2('park1234',256)), '박테스터', 0, '2025-08-01 14:45:00', '2025-09-01 18:12:00', 'ACTIVE'),
  ('hong@example.com',  UPPER(SHA2('hongpw90',256)), '홍리뷰',  0, '2025-08-03 10:15:00', '2025-09-02 22:10:00', 'ACTIVE')
ON DUPLICATE KEY UPDATE
  nickname=VALUES(nickname),
  is_admin=VALUES(is_admin),
  last_login_at=VALUES(last_login_at),
  status=VALUES(status);

-- 2) Boards (idempotent; 이미 존재하면 갱신)
INSERT INTO boards (code, name, description, admin_only) VALUES
  ('QNA',    'Q&A',      '질문과 답변', 0),
  ('KNOW',   '지식나눔',  '지식 공유',   0),
  ('FREE',   '자유',      '자유 게시판', 0),
  ('NOTICE', '공지',      '운영자 공지', 1)
ON DUPLICATE KEY UPDATE
  name=VALUES(name),
  description=VALUES(description),
  admin_only=VALUES(admin_only);

-- 3) Posts
-- 3-1) Notices (상단 고정)
INSERT INTO posts (board_id, author_email, title, content_html, pinned, view_count, created_at, updated_at) VALUES
  (@NOTICE, 'admin@example.com', '서비스 점검 안내 (9/10 02:00~03:00)',
   '<p>안정적인 서비스 제공을 위해 9월 10일 새벽 점검이 있습니다.</p>', 1, 120,
   '2025-08-28 09:00:00', '2025-08-28 09:00:00'),
  (@NOTICE, 'admin@example.com', '게시판 이용 수칙',
   '<ul><li>서로를 존중해요</li><li>광고/도배 금지</li><li>주제에 맞게 게시</li></ul>', 1, 340,
   '2025-08-05 10:30:00', '2025-08-05 10:30:00');

-- 3-2) Q&A 샘플 6건
INSERT INTO posts (board_id, author_email, title, content_html, view_count, created_at, updated_at, pinned) VALUES
  (@QNA, 'kim@example.com', 'JDBC 커넥션 풀 설정이 궁금해요',
   '<p>Tomcat JNDI로 DataSource를 쓰려면 어떻게 설정하나요?</p>', 56,
   '2025-08-20 11:00:00', '2025-08-20 11:00:00', 0),
  (@QNA, 'lee@example.com', 'DAO에서 트랜잭션 처리 패턴 추천?',
   '<p>서비스 레이어에서 트랜잭션을 여는 게 맞을까요?</p>', 33,
   '2025-08-22 15:40:00', '2025-08-22 15:40:00', 0),
  (@QNA, 'park@example.com','PreparedStatement와 Statement 차이',
   '<p>성능/보안 측면에서 차이를 정리해주실 분?</p>', 44,
   '2025-08-25 09:20:00', '2025-08-25 09:20:00', 0),
  (@QNA, 'hong@example.com','JSP에서 JSTL 의존성 추가법',
   '<p>pom.xml에 어떤 artifactId를 써야 하나요?</p>', 27,
   '2025-08-26 13:10:00', '2025-08-26 13:10:00', 0),
  (@QNA, 'kim@example.com', '페이징 쿼리 LIMIT/OFFSET 예시',
   '<p>MySQL에서 10개씩 끊어서 가져오는 예시가 궁금합니다.</p>', 61,
   '2025-08-27 16:00:00', '2025-08-27 16:00:00', 0),
  (@QNA, 'lee@example.com', '서블릿 필터로 인코딩 처리 어떻게?',
   '<p>UTF-8 강제 필터 예제 부탁드려요.</p>', 22,
   '2025-08-29 19:05:00', '2025-08-29 19:05:00', 0);

-- 3-3) 지식나눔(튜토리얼성) 4건
INSERT INTO posts (board_id, author_email, title, content_html, view_count, created_at, updated_at) VALUES
  (@KNOW, 'kim@example.com',  'MySQL 인덱스 가이드',
   '<p>커버링 인덱스/조합 인덱스 설계 팁을 정리했습니다.</p>', 73, '2025-08-18 10:00:00','2025-08-18 10:00:00'),
  (@KNOW, 'lee@example.com',  'JSTL fmt로 날짜 포매팅',
   '<p>&lt;fmt:formatDate&gt; 예시 모음입니다.</p>', 41, '2025-08-21 09:10:00','2025-08-21 09:10:00'),
  (@KNOW, 'park@example.com', '서블릿 3.1 비동기 처리 요약',
   '<p>AsyncContext 사용법과 타임아웃 처리 정리.</p>', 29, '2025-08-23 14:22:00','2025-08-23 14:22:00'),
  (@KNOW, 'hong@example.com', 'XSS 방지 기본기',
   '<p>출력 인코딩과 화이트리스트 정책 권장.</p>', 88, '2025-08-30 17:30:00','2025-08-30 17:30:00');

-- 3-4) 자유게시판 4건
INSERT INTO posts (board_id, author_email, title, content_html, view_count, created_at, updated_at) VALUES
  (@FREE, 'kim@example.com',  '오늘 공원에서 본 강아지 🐶',
   '<p>너무 귀여워서 사진 찍었어요!</p>', 150, '2025-08-24 12:34:00','2025-08-24 12:34:00'),
  (@FREE, 'lee@example.com',  '개발 밈 추천 좀 ㅋㅋ',
   '<p>요즘 핫한 밈 뭐 있나요?</p>', 64, '2025-08-26 20:01:00','2025-08-26 20:01:00'),
  (@FREE, 'park@example.com', '취미로 만드는 라면 레시피',
   '<p>계란/치즈/버터 조합 최강 논쟁 시작!</p>', 77, '2025-08-28 08:20:00','2025-08-28 08:20:00'),
  (@FREE, 'hong@example.com', '개발자 번아웃 극복 팁',
   '<p>짧은 산책과 루틴 관리 추천드립니다.</p>', 132, '2025-08-31 09:45:00','2025-08-31 09:45:00');

-- 4) Comments
-- Resolve some post ids by title/board for convenience
SET @P_QNA1 := (SELECT p.post_id FROM posts p JOIN boards b ON p.board_id=b.board_id
                WHERE b.code='QNA' AND p.title='JDBC 커넥션 풀 설정이 궁금해요' ORDER BY p.post_id DESC LIMIT 1);
SET @P_QNA2 := (SELECT p.post_id FROM posts p JOIN boards b ON p.board_id=b.board_id
                WHERE b.code='QNA' AND p.title='DAO에서 트랜잭션 처리 패턴 추천?' ORDER BY p.post_id DESC LIMIT 1);
SET @P_KNOW1 := (SELECT p.post_id FROM posts p JOIN boards b ON p.board_id=b.board_id
                WHERE b.code='KNOW' AND p.title='MySQL 인덱스 가이드' ORDER BY p.post_id DESC LIMIT 1);
SET @P_FREE1 := (SELECT p.post_id FROM posts p JOIN boards b ON p.board_id=b.board_id
                WHERE b.code='FREE' AND p.title='오늘 공원에서 본 강아지 🐶' ORDER BY p.post_id DESC LIMIT 1);

INSERT INTO comments (post_id, author_email, content, created_at, updated_at) VALUES
  (@P_QNA1,  'lee@example.com',  'context.xml에 Resource 정의 후, JNDI lookup 하시면 됩니다.', '2025-08-20 12:10:00','2025-08-20 12:10:00'),
  (@P_QNA1,  'park@example.com', 'web.xml에서 resource-ref도 잊지 마세요!',             '2025-08-20 12:40:00','2025-08-20 12:40:00'),
  (@P_QNA2,  'kim@example.com',  '네, 서비스 레이어에서 트랜잭션 관리 추천이요.',        '2025-08-22 16:00:00','2025-08-22 16:00:00'),
  (@P_KNOW1, 'hong@example.com', '커버링 인덱스 사례 유익했습니다, 감사합니다.',          '2025-08-18 11:20:00','2025-08-18 11:20:00'),
  (@P_FREE1, 'admin@example.com','사진 공유해주세요! 😄',                               '2025-08-24 13:00:00','2025-08-24 13:00:00');

-- 5) Likes / Scraps
INSERT INTO post_likes (post_id, user_email, created_at)
SELECT @P_QNA1, 'kim@example.com',  '2025-08-20 12:11:00' UNION ALL
SELECT @P_QNA1, 'hong@example.com', '2025-08-20 12:12:00' UNION ALL
SELECT @P_FREE1,'lee@example.com',  '2025-08-24 13:01:00';

INSERT INTO post_scraps (post_id, user_email, created_at)
SELECT @P_KNOW1, 'lee@example.com',  '2025-08-18 11:30:00' UNION ALL
SELECT @P_QNA2,  'park@example.com', '2025-08-22 16:05:00';

-- 6) Attachments
INSERT INTO post_attachments (post_id, file_name, file_path, file_size, content_type, created_at)
SELECT @P_KNOW1, 'index_guide.pdf', '/upload/2025/08/index_guide.pdf', 524288, 'application/pdf', '2025-08-18 10:05:00' UNION ALL
SELECT @P_FREE1, 'doggo.jpg',       '/upload/2025/08/doggo.jpg',       204800, 'image/jpeg',      '2025-08-24 12:40:00';

-- 7) (선택) 집계 필드 동기화
-- 댓글 수는 트리거로 자동 증가/감소합니다.
-- 좋아요/스크랩 카운트는 아래 업데이트로 동기화할 수 있습니다.
UPDATE posts p
SET
  like_count  = (SELECT COUNT(*) FROM post_likes  l WHERE l.post_id = p.post_id),
  scrap_count = (SELECT COUNT(*) FROM post_scraps s WHERE s.post_id = p.post_id);

-- 검증용 간단 조회
-- SELECT * FROM v_user_summary ORDER BY joined_at;
-- SELECT p.post_id, b.code, p.title, p.comment_count, p.like_count, p.scrap_count FROM posts p JOIN boards b ON p.board_id=b.board_id ORDER BY p.created_at DESC;

-- 끝.
