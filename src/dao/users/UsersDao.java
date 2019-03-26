package dao.users;

import dto.Users;

public interface UsersDao {

	
	//userid와 userpw가 일치하는 회원 수 조회
	public int seletCntUserByUid(Users u);
	
	// userid로 user정보조회
	public Users selectUserByUid(Users u);
	
	public boolean login(Users u);

	
}
