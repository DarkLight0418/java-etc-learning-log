package mvcBoardPJ.com.example.model;

public class ZipSQL {
	
	final static String POST_LOAD = "select * from POSTS where post_id=?";
	final static String LOAD_LIST = "select * from POSTS";
	final static String INSERT_POST = "insert into POSTS(board_id, email, title, content, created_at, updated_at) values(?, ?, ?, ?, now(), now())";

	
	final static String LOGIN_INFO = "select email, password_temp from USERS where email=?";
	final static String EXIST_EMAIL = "SELECT 1 FROM USERS WHERE email = ?";
	final static String ID_PW_COLLECT = "SELECT password_temp FROM USERS WHERE email = ?"; 
	final static String INSERT_MEMBER = "INSERT INTO USERS (email, nickname, password_temp, joined_at) VALUES (?, ?, ?, NOW())";
}
