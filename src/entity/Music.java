package entity;

public class Music {
	private int sId;
	private String sTitle;	//投票标题
	private String sType;	//投票类型
	private int sBrowseTotal;//总浏览数
	private int sParticipate;//总参与人数
	private int sVotetotal;//总票数
	private String sImage;//封面图片地址
	private String sMusic;//视频地址
	
	public Music() {
	}
	
	public Music(int sId, String sTitle, String sType, int sBrowseTotal,
			int sParticipate, int sVotetotal, String sImage, String sMusic) {
		this.sId = sId;
		this.sTitle = sTitle;
		this.sType = sType;
		this.sBrowseTotal = sBrowseTotal;
		this.sParticipate = sParticipate;
		this.sVotetotal = sVotetotal;
		this.sImage = sImage;
		this.sMusic = sMusic;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public int getsBrowseTotal() {
		return sBrowseTotal;
	}

	public void setsBrowseTotal(int sBrowseTotal) {
		this.sBrowseTotal = sBrowseTotal;
	}

	public int getsParticipate() {
		return sParticipate;
	}

	public void setsParticipate(int sParticipate) {
		this.sParticipate = sParticipate;
	}

	public int getsVotetotal() {
		return sVotetotal;
	}

	public void setsVotetotal(int sVotetotal) {
		this.sVotetotal = sVotetotal;
	}

	public String getsImage() {
		return sImage;
	}

	public void setsImage(String sImage) {
		this.sImage = sImage;
	}

	public String getsMusic() {
		return sMusic;
	}

	public void setsMusic(String sMusic) {
		this.sMusic = sMusic;
	}

}
