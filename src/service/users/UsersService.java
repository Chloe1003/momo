package service.users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Users;

public interface UsersService {

	//요청 파라미터 처리
	public Users getParam(HttpServletRequest req, HttpServletResponse resp);

    //	id/pw 일치확인?
	public boolean login(Users user);
	
	public Users getUserByUid(Users user);

	
}
