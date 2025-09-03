package mvcBoardPJ.com.example.domain;

public class Member {
	private String id;
	private String pwdHash;
	
	public Member() {}
	
	public Member(String id, String pwdHash) {
		this.id = id;
		this.pwdHash = pwdHash;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPwdHash() {
		return pwdHash;
	}
	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}
}
