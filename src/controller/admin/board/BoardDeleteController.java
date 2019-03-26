package controller.admin.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import dto.BoardComment;
import service.admin.board.BoardService;
import service.admin.board.BoardServiceImpl;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//요청파라미터 -> MODEL
		Board board = boardService.getParam(req, resp);
		
		//게시글삭제 수행
		boardService.delete(board.getB_no());
		
	
		
		//MODEL 전달
//		req.setAttribute("boarddel", boarddel);
		
		//VIEW지정
		req.getRequestDispatcher("/view/admin/board/delete.jsp")
			.forward(req, resp);
		
	}
	
}







