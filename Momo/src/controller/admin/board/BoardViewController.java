package controller.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.admin.board.BoardService;
import service.admin.board.BoardServiceImpl;

@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터 -> MODEL
		Board board = boardService.getParam(req, resp);
		
		//게시글 조회수행
		Board boardview = boardService.view(board);
		
		//MODEL 전달
		req.setAttribute("boardview", boardview);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/board/view.jsp")
			.forward(req, resp);
		
	}
	
}







