package entity;

public class User {
	private int uId;
	private String uName;
	private String uPass;
	private int uStatus;
	private String uEmail;
	
	public User() {

	}

	public User(int uId, String uName, String uPass, int uStatus, String uEmail) {
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
		this.uStatus = uStatus;
		this.uEmail = uEmail;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	public int getuStatus() {
		return uStatus;
	}

	public void setuStatus(int uStatus) {
		this.uStatus = uStatus;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}	
}
