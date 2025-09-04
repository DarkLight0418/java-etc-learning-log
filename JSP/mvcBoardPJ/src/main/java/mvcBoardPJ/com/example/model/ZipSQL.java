package mvcBoardPJ.com.example.model;

public class ZipSQL {
	final static String LOGIN_INFO = "select email, password_temp from USERS where email=?";
	final static String POST_LOAD = "select * from POSTS where post_id=?";
	final static String LOAD_LIST = "select * from POSTS";
	final static String INSERT_POST = "insert into POSTS(email, title, content, fname, rdate) values(?, ?, ?, ?, now())";
}
