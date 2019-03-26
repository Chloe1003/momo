package util;

//searchStudy할 때 조건 처리해줄 dto 추가
public class Handling {

	//카테고리 선택시 요청 파라미터 처리할 dto
	private String cateCode;
	private int cate;
	private String selRegion;
	private String time;
	private String gender;
	
	@Override
	public String toString() {
		return "Handling [cateCode=" + cateCode + ", cate=" + cate + ", selRegion=" + selRegion + ", time=" + time
				+ ", gender=" + gender + "]";
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getCate() {
		return cate;
	}
	public void setCate(int cate) {
		this.cate = cate;
	}
	public String getSelRegion() {
		return selRegion;
	}
	public void setSelRegion(String selRegion) {
		this.selRegion = selRegion;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	
}