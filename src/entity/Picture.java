package entity;

public class Picture {
	private int pId;
	private String pDescription;
	private String pImage;
	private int pTicket;
	public Picture() {
	}
	public Picture(int pId, String pDescription, String pImage, int pTicket) {
		this.pId = pId;
		this.pDescription = pDescription;
		this.pImage = pImage;
		this.pTicket = pTicket;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public int getpTicket() {
		return pTicket;
	}
	public void setpTicket(int pTicket) {
		this.pTicket = pTicket;
	}
	
	
}
