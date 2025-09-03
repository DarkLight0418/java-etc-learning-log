package mvcBoardPJ.com.example.model;

public class ZipSQL {
	final static String LOGIN_INFO = "select email, password_temp from USERS where email=?";
	final static String POST_LOAD = "select * from POSTS where post_id=?";
	final static String LOAD_LIST = "select * from POSTS";
}
