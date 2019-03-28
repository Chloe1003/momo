package controller.team;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Schedule;
import dto.Study;
import dto.Teammate;
import service.schedule.ScheduleService;
import service.schedule.ScheduleServiceImpl;
import service.team.TeamService;
import service.team.TeamServiceImpl;


@WebServlet("/team/main")
public class TeamMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TeamService tServ = new TeamServiceImpl();
	ScheduleService scServ = new ScheduleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		int u_no = (int) session.getAttribute("u_no");
//		int study_no = (int) session.getAttribute("study_no");
		int study_no = 1;
		Study study = tServ.getStudy(study_no);
		List<Teammate> teammate = tServ.getTeammate(study_no);
		Schedule schedule = scServ.getLatestSchedule(study_no);
		
		int d_day = scServ.getDday(study_no);
	
		
		req.setAttribute("study", study);
		req.setAttribute("teammate", teammate);
		req.setAttribute("schedule", schedule);
		req.setAttribute("d_day", d_day);

		req.getRequestDispatcher("/view/team/teamMain.jsp").forward(req, resp);
	}
}
