package root.pack.lms.valueobject;

public class VGangjwa {
	private int id;
	private String user;
	private String gangjwaName;
	private String gyosuName;
	private int hakjeom;
	private String time;
	private int sincheong = 0;
	private String fileName;
	
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getSincheong() {
		return sincheong;
	}
	public void setSincheong(int sincheong) {
		this.sincheong = sincheong;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGangjwaName() {
		return gangjwaName;
	}
	public void setGangjwaName(String gangjwaName) {
		this.gangjwaName = gangjwaName;
	}
	public String getGyosuName() {
		return gyosuName;
	}
	public void setGyosuName(String gyosuName) {
		this.gyosuName = gyosuName;
	}
	public int getHakjeom() {
		return hakjeom;
	}
	public void setHakjeom(int hakjeom) {
		this.hakjeom = hakjeom;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
