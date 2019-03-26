package dto;

public class ApplyState {

	private int ts_statecode;//신청상태코드
	private String ts_statename;//신청상 이름
	@Override
	public String toString() {
		return "ApplyState [ts_statecode=" + ts_statecode + ", ts_statename=" + ts_statename + "]";
	}
	public int getTs_statecode() {
		return ts_statecode;
	}
	public void setTs_statecode(int ts_statecode) {
		this.ts_statecode = ts_statecode;
	}
	public String getTs_statename() {
		return ts_statename;
	}
	public void setTs_statename(String ts_statename) {
		this.ts_statename = ts_statename;
	}
	
	
}
