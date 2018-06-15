package domain.login;

public class AdminEvents {


	private String title;
	private String desc;
	
	public AdminEvents(String title, String desc){
		this.title = title;
		this.desc = desc;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getdesc() {
		return desc;
	}
	public void setdesc(String desc) {
		this.desc = desc;
	}

}
