package dao.users;

import dto.Users;

public interface UsersDao {

	
	//userid�� userpw�� ��ġ�ϴ� ȸ�� �� ��ȸ
	public int seletCntUserByUid(Users u);
	
	// userid�� user������ȸ
	public Users selectUserByUid(Users u);
	
	public boolean login(Users u);

	
}
