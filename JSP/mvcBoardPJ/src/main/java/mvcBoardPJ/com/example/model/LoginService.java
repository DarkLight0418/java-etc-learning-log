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
		m.setPwdHash("");
		
		return m;
	}
	
	public String check(String id, String password_hash) {
		Member m = boardDao.getLoginInfo(id);
		
		if (m == null) {
			return "null";
		} else {
			String dbPwd = m.getPwdHash();
			if (dbPwd != null) dbPwd.trim();
			
			if (!dbPwd.equals(password_hash)) {
				return "pwdError";
			} else {
				return "success";
			}
		}
	}
}
