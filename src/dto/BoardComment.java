package dto;

import java.util.Date;

public class BoardComment {

	private int bc_no ;
	private String bc_comment;
	private int bc_name;    
	private Date bc_date;     
	private int bc_reno;       
	private int bc_idx; 
	
	@Override
	public String toString() {
		return "BoardComment [bc_no=" + bc_no + ", bc_comment=" + bc_comment + ", bc_name=" + bc_name + ", bc_date="
				+ bc_date + ", bc_reno=" + bc_reno + ", bc_idx=" + bc_idx + ", b_no=" + b_no + "]";
	}
	private int b_no;   ;
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public int getBc_no() {
		return bc_no;
	}
	public void setBc_no(int bc_no) {
		this.bc_no = bc_no;
	}
	public String getBc_comment() {
		return bc_comment;
	}
	public void setBc_comment(String bc_comment) {
		this.bc_comment = bc_comment;
	}
	public int getBc_name() {
		return bc_name;
	}
	public void setBc_name(int bc_name) {
		this.bc_name = bc_name;
	}
	public Date getBc_date() {
		return bc_date;
	}
	public void setBc_date(Date bc_date) {
		this.bc_date = bc_date;
	}
	public int getBc_reno() {
		return bc_reno;
	}
	public void setBc_reno(int bc_reno) {
		this.bc_reno = bc_reno;
	}
	public int getBc_idx() {
		return bc_idx;
	}
	public void setBc_idx(int bc_idx) {
		this.bc_idx = bc_idx;
	}
	
	
	
}
