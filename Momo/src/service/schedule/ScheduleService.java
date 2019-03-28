package service.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Faq;
import dto.Report;
import dto.Schedule;

public interface ScheduleService {

	//��û�Ķ���� �����͸� ��üȭ�Ͽ� ��ȯ
	public Schedule getParam(HttpServletRequest req, HttpServletResponse resp);
	
	// ���� ��ü ��ȸ
	public List<Schedule> selectAll();


	// ���� ���� ��ȯ
	public int delete(Schedule schedel);
	
	
	// ���� ���
	public void Insert(Schedule scheinsert);

//	// ���� ����
//	public void update(Schedule faqup);
	
	// yn start -------------------------------
	public Schedule getLatestSchedule(int study_no);

	public int getDday(int study_no);


}
