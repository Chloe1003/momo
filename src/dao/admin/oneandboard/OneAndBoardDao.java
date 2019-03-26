package dao.admin.oneandboard;

import java.util.List;

import dto.NoticeBoard;
import dto.OneAndBoard;
import dto.Users;
import util.Paging;

public interface OneAndBoardDao {

	//1대1 전체 조회
	public List selectAll();


	//1대1 상세조회 반환
	public OneAndBoard selectOneBoardByOneno(OneAndBoard oboardview);
	
	//총 게시글 수 반환
	public int selectCntOneBoard();
	
	//페이징 처리 게시글 반환
	public List selectPaginglist(Paging paging);
		

	//답변 등록 
	public void oneAndBoardUpdate(OneAndBoard oboardUpdate);
	
	//1대1문의 검색
	public List<OneAndBoard> search(String type, String word);
	
}


















