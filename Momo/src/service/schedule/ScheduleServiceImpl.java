package service.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.schedule.ScheduleDao;
import dao.schedule.ScheduleDaoImpl;
import dto.Schedule;

public class ScheduleServiceImpl implements ScheduleService {

	private ScheduleDao schedao = new ScheduleDaoImpl();
	
	
	@Override
	public Schedule getParam(HttpServletRequest req, HttpServletResponse resp) {
		
		//��û�Ķ���� ������ ������ DTO��ü
		Schedule sche = new Schedule();
		
		//��û�Ķ���� �ޱ�
		String s_no= req.getParameter("s_no");
		
		//null�̳� ""�� �ƴϸ� int�� ��ȯ�Ͽ� DTO�� ����
		if( s_no!= null && !"".equals(s_no) ) {
			sche.setS_no((Integer.parseInt(s_no)));
		}

		//��û�Ķ���Ͱ� ��ü�� ��ȯ�� DTO ��ȯ
		return sche;
	}

	@Override
	public List<Schedule> selectAll() {
		
		return schedao.selectAll();
	}

	

	
	@Override
	public void Insert(Schedule scheinsert) {
		
		schedao.scheInsert(scheinsert);
	}

	@Override
	public int delete(Schedule schedel) {
	    
		return schedao.scheDelect(schedel);
	}

	// yn start -------------------------------------
	@Override
	public Schedule getLatestSchedule(int study_no) {
		
		return schedao.selectLatestSchedule(study_no);
	}

	@Override
	public int getDday(int study_no) {
		return schedao.getDday(study_no);
	}
	
	//--------------------------------------------------

	



}
