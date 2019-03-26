package dao.admin.usersmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import dto.NoticeBoard;
import dto.Users;
import util.DBConn;
import util.Paging;

public class UsersDaoImpl implements UsersDao {

	//DB연결 객체
	private Connection conn = DBConn.getConnection(); 

	@Override
	public List selectAll() {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM users";
		sql += " ORDER BY u_no DESC";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//최종 조회 결과 담을 List
		List list = new ArrayList<>();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//전체조회 결과 담기
			while(rs.next()) {
				Users u = new Users();
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				u.setU_no( rs.getInt("u_no") );
				u.setU_id( rs.getString("nb_id") );
				u.setU_pw( rs.getString("nb_pw") );
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getDate("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );				

				//조회결과를 List로 생성
				list.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체조회 결과 반환
		return list;
	}

	

	@Override
	public Users selectUsersByUsersno(Users usersview) {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM users";
		sql += " WHERE u_no= ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//조회 결과 담을 DTO
		Users u = new Users();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, usersview.getU_no());
			rs = ps.executeQuery();
			
			//결과 담기
			while(rs.next()) {		
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				u.setU_no( rs.getInt("u_no") );
				u.setU_id( rs.getString("u_id") );
				u.setU_pw( rs.getString("u_pw") );
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getDate("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체조회 결과 반환
		return u;
	}

	@Override
	public int selectCntUsers() {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT COUNT(*) FROM users";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//최종 조회 결과 담을 변수
		int cnt = 0;
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체 게시글 수 반환
		return cnt;
	}

	@Override
	public List selectPaginglist(Paging paging) {

		//전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, B.* FROM (";
		sql += "	SELECT * FROM users";
		sql += "	ORDER BY u_no desc";
		sql += " ) B";
		sql += " ORDER BY rnum";
		sql += ") R";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		//최종 조회 결과 담을 List
		List list = new ArrayList<>();
		
		try {
			//DB작업
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();
			
			//전체조회 결과 담기
			while(rs.next()) {
                Users u = new Users();
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				u.setU_no( rs.getInt("u_no") );
				u.setU_id( rs.getString("u_id") );
				u.setU_pw( rs.getString("u_pw") );
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getDate("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );		
				//조회결과를 List로 생성
				list.add(u);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//DB객체 닫기
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 전체조회 결과 반환
		return list;
	}



	@Override
	public boolean deleteUsersByUsersno(Users usersdel) {
		//전체 조회 쿼리
				String sql = "";
				sql += "DELETE FROM users";
				sql += " WHERE u_no= ?";
				
				
				int result = 0;
				boolean deleteresult = false;

				
				//DB 객체
				PreparedStatement ps = null; 
				ResultSet rs = null;
	
				
				try {
					//DB작업
					ps = conn.prepareStatement(sql);
					ps.setInt(1, usersdel.getU_no());
					
					
					result = ps.executeUpdate();
					
//					Users u = new Users();
//					//결과 담기
//					while(rs.next()) {		
//						
//						//ResultSet의 결과 행 하나씩 DTO에 저장
//						u.setU_no( rs.getInt("u_no") );
//						u.setU_id( rs.getString("u_id") );
//						u.setU_pw( rs.getString("u_pw") );
//						u.setU_name( rs.getString("u_name") );
//						u.setU_phone( rs.getString("u_phone") );
//						u.setU_email( rs.getString("u_email") );				
//						u.setU_birth( rs.getDate("u_birth") );				
//						u.setU_regdate( rs.getDate("u_regdate") );		
//					}  
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						//DB객체 닫기
						if(rs!=null)	rs.close();
						if(ps!=null)	ps.close();
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (result > 0) {
					deleteresult = true;
				} else {
					deleteresult = false;
				}
				return deleteresult;

	}
	@Override
	public List<Users> search(String type, String word) {

		// 전체 조회 쿼리
		String sql = "";
		sql += "SELECT * FROM users";

		if (type.equals("no")) {
			sql += " WHERE u_no like ?";
		} else if (type.equals("name")) {
			sql += " WHERE u_name like ?";
		} 

		
		// DB 객체
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 최종 조회 결과 담을 List
		List list = new ArrayList<>();

		try {
			// DB작업
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + word + "%");
			rs = ps.executeQuery();
			
	
			// 전체조회 결과 담기
			while (rs.next()) {
                Users u = new Users();
				
				//ResultSet의 결과 행 하나씩 DTO에 저장
				u.setU_no( rs.getInt("u_no") );
			
				u.setU_name( rs.getString("u_name") );
				u.setU_phone( rs.getString("u_phone") );
				u.setU_email( rs.getString("u_email") );				
				u.setU_birth( rs.getDate("u_birth") );				
				u.setU_regdate( rs.getDate("u_regdate") );				

				//조회결과를 List로 생성
				list.add(u);
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


}















