package controller.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.NoticeBoard;
import service.admin.board.BoardService;
import service.admin.board.BoardServiceImpl;
import service.admin.noticeboard.NoticeBoardService;
import service.admin.noticeboard.NoticeBoardServiceImpl;
import util.Paging;

@WebServlet("/board/search")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		req.setCharacterEncoding("utf-8");


		String type = req.getParameter("type");
		String word = req.getParameter("word");
		
		System.out.println(type+" 이름");
		System.out.println(word+" word");
		

		// 게시글목록 MODEL로 추가
		List<Board> boardlist = boardService.getSearch(type, word);
		
		req.setAttribute("boardlist", boardlist);


		//VIEW지정
		req.getRequestDispatcher("/view/admin/board/list.jsp")
			.forward(req, resp);
		
	}
	
}







