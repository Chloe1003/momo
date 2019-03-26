package dto;

public class StudyCateGory {

	private int st_catecode;//대분류코드
	private String st_catename;//대분류이름
	
	@Override
	public String toString() {
		return "StudyCateGory [st_catecode=" + st_catecode + ", st_catename=" + st_catename + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public int getSt_catecode() {
		return st_catecode;
	}
	public void setSt_catecode(int st_catecode) {
		this.st_catecode = st_catecode;
	}
	public String getSt_catename() {
		return st_catename;
	}
	public void setSt_catename(String st_catename) {
		this.st_catename = st_catename;
	}

}
