package dao.schedule;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Faq;
import dto.Schedule;
import dto.Study;
import util.DBConn;

public class ScheduleDaoImpl implements ScheduleDao {

	private Connection conn = DBConn.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Schedule> selectAll() {

		// 전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM schedule";
		sql += " ORDER BY s_no";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List<Schedule> list = new ArrayList<>();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			// 전체조회 결과 담기
			while (rs.next()) {
				Schedule s = new Schedule();

				// ResultSet의 결과 행 하나씩 DTO에 저장

				s.setS_no(rs.getInt("s_no"));
				s.setS_title(rs.getString("s_title"));
				s.setS_content(rs.getString("s_content"));
				s.setS_end(rs.getString("s_end"));
				s.setS_start(rs.getString("s_start"));
				
				s.setStudy_no(rs.getInt("study_no"));
				s.setS_cname(rs.getString("s_cname"));
				
				s.setS_date(rs.getDate("s_date"));
				s.setS_partname(rs.getString("s_partname"));
				s.setS_place(rs.getString("s_place"));
				s.setS_rdate(rs.getDate("s_rdate"));
				s.setS_name(rs.getString("s_name"));
				
				s.setP_lat(rs.getDouble("p_lat"));
				s.setP_lng(rs.getDouble("p_lng"));
				s.setP_address(rs.getString("p_address"));
				
				
				// 조회결과를 List로 생성
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 전체조회 결과 반환
		return list;
	}



	@Override
	public int scheDelect(Schedule schedel) {
		// 전체 조회 쿼리
		int result = 1;

		String sql = "";
		sql += "DELETE FROM schedule";
		sql += " WHERE s_no= ?";

		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 조회 결과 담을 DTO

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, schedel.getS_no());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 전체조회 결과 반환
		return result;
	}

	@Override
	public void scheInsert(Schedule scheinsert) {

		PreparedStatement ps = null;
	      ResultSet rs = null;
	      String sql = " ";
	      sql += "INSERT INTO schedule";
	      sql += " (s_no, study_no, s_title, s_content, s_cname, s_date, s_partname, s_place";
	      sql += " ,s_rdate, s_name, s_start, s_end, p_lat, p_lng, p_address)";
	      sql += " VALUES( schedule_SEQ.NEXTVAL, 1, ?, ?, '아무개', sysdate, '김준환', ?, sysdate,'김준환',?,?,?,?,?)";

	      try {

	         ps = conn.prepareStatement(sql);

	         ps.setString(1, scheinsert.getS_title());
	         ps.setString(2, scheinsert.getS_content());
	         
	         ps.setString(3,  scheinsert.getS_place());
	         
	         ps.setString(4,  scheinsert.getS_start());
	         ps.setString(5,  scheinsert.getS_end());
	         ps.setDouble(6,  scheinsert.getP_lat());
	         ps.setDouble(7,  scheinsert.getP_lng());
	         ps.setString(8,  scheinsert.getP_address());

	         ps.executeUpdate();
	         
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB객체 닫기
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 수정 함수
	public void update(Faq faqup) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " ";
		sql += "update faq ";
		sql += " SET faq_cate = ?, faq_qusetion = ? , faq_answer= ?";
		sql += " WHERE faq_no = ?";
		try {

			ps = conn.prepareStatement(sql);

			ps.setString(1, faqup.getFaq_cate());

			ps.setString(2, faqup.getFaq_qusetion());

			ps.setString(3, faqup.getFaq_answer());

			ps.setInt(4, faqup.getFaq_no());



			ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}



	@Override
	public int selectCntFaq() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void update(Schedule faqup) {
		// TODO Auto-generated method stub
		
	}

	// yn start -------------------------------------------------------------------------

	@Override
	public Schedule selectLatestSchedule(int study_no) {
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, A.* FROM(";
		sql += "		SELECT s_start, s_end, s_place, p_address, s_title, p_lng, p_lat";
		sql += " 		FROM schedule";
		sql += " 	WHERE(s_start - sysdate) > 0 AND study_no=1";
		sql += "	ORDER BY (sysdate - s_start) DESC ";
		sql += " 	) A";
		sql += " 	ORDER BY rnum";
		sql += " ) R";
		sql += " WHERE rnum= 1";
		
		Schedule sc = new Schedule();	

		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, study_no);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				sc.setS_start(rs.getString("s_start"));
				sc.setS_end(rs.getString("s_end"));
				sc.setS_place(rs.getString("s_place"));
				sc.setP_address(rs.getString("p_address"));
				sc.setS_title(rs.getString("s_title"));
				sc.setP_lat(rs.getDouble("p_lat"));
				sc.setP_lng(rs.getDouble("p_lng"));
			};
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return sc;
	}



	@Override
	public int getDday(int study_no) {
		String sql = "";
		sql +="SELECT trunc(STUDY_PERIOD) - trunc(SYSDATE) FROM study";
		sql += " WHERE study_no=1";
		
		int dDay=0;

		try {
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, study_no);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			dDay = rs.getInt(1);	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
		return dDay;
	}



	// -----------------------------------------------------------

}
