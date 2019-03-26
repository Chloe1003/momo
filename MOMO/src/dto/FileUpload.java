package dto;

import java.sql.Date;

public class FileUpload {

	private int file_no;//파일번호
	private String file_originname;//파일 원이름
	private String file_stroedname;//파일 저장이름
	private Date file_uploaddate;//파일업로드 날짜
	private int fut_code;//게시판코드
	@Override
	public String toString() {
		return "FileUpload [file_no=" + file_no + ", file_originname=" + file_originname + ", file_stroedname="
				+ file_stroedname + ", file_uploaddate=" + file_uploaddate + ", fut_code=" + fut_code + "]";
	}
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public String getFile_originname() {
		return file_originname;
	}
	public void setFile_originname(String file_originname) {
		this.file_originname = file_originname;
	}
	public String getFile_stroedname() {
		return file_stroedname;
	}
	public void setFile_stroedname(String file_stroedname) {
		this.file_stroedname = file_stroedname;
	}
	public Date getFile_uploaddate() {
		return file_uploaddate;
	}
	public void setFile_uploaddate(Date file_uploaddate) {
		this.file_uploaddate = file_uploaddate;
	}
	public int getFut_code() {
		return fut_code;
	}
	public void setFut_code(int fut_code) {
		this.fut_code = fut_code;
	}
	
}
