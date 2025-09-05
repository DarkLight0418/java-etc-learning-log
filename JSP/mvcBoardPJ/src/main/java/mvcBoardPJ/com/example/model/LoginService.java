package mvcBoardPJ.com.example.model;

import mvcBoardPJ.com.example.domain.Member;

public class LoginService {
	private BoardDAO boardDao;
	
	private static final LoginService instance = new LoginService();
	// 싱글톤 (객체 하나 생성 후 우려먹기)
	
	private LoginService() {
		boardDao = new BoardDAO();
	}
	
	public static LoginService getInstance() {
		return instance;
	}
	
	public Member getLoginInfos(String id) {
		Member m = boardDao.getLoginInfo(id);
		return m;
	}
	
	public String check(String id, String password_temp) {
		Member m = boardDao.getLoginInfo(id);
		
		if (m == null) {
			return "null";
		} else {
			String dbPwd = m.getPwdHash();
			if (dbPwd != null) dbPwd = dbPwd.trim();
			if (!dbPwd.equals(password_temp)) {
				return "pwdError";
			} else {
				return "success";
			}
		}
	}
	public boolean register(String email, String nickname, String password) {
		if (boardDao.existByEmail(email)) return false;
		return boardDao.insertMember(email, nickname, password) == 1;
	}
}
