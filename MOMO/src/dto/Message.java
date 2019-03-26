package dto;

import java.util.Date;

public class Message{

	private int m_no;//쪽지번호
	private String m_comment;//쪽지내용
	private String m_read;//열람여부
	private Date m_date;//발신시간
	private Date m_rdate;//조회시간
	private int sender_no;//발신자
	private String u_name;//????
	private int receiver_no;//수신자
	
	public int getM_no() {
		return m_no;
	}
	public void setM_no(int m_no) {
		this.m_no = m_no;
	}
	public String getM_comment() {
		return m_comment;
	}
	public void setM_comment(String m_comment) {
		this.m_comment = m_comment;
	}
	public String getM_read() {
		return m_read;
	}
	public void setM_read(String m_read) {
		this.m_read = m_read;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	public Date getM_rdate() {
		return m_rdate;
	}
	public void setM_rdate(Date m_rdate) {
		this.m_rdate = m_rdate;
	}
	public int getSender_no() {
		return sender_no;
	}
	public void setSender_no(int sender_no) {
		this.sender_no = sender_no;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getReceiver_no() {
		return receiver_no;
	}
	public void setReceiver_no(int receiver_no) {
		this.receiver_no = receiver_no;
	}
	
	
	
	
}
