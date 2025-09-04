
-- Minimal INSERT templates (content LONGTEXT)
-- Get board id by code:
--   SELECT board_id FROM boards WHERE code=?;

-- Insert post without file (plain text content):
INSERT INTO posts (board_id, email, title, content) VALUES (?, ?, ?, ?);

-- Example with NOW():
-- INSERT INTO posts (board_id, email, title, content, created_at) VALUES (?, ?, ?, ?, NOW());
