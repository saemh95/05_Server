package edu.kh.sudoku.play.easy.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.sudoku.member.dto.Member;
import edu.kh.sudoku.play.model.dto.Sudoku;
import edu.kh.sudoku.play.model.service.PlayService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/play/easy")
public class EasyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		PlayService service = new PlayService();
		Member loginMember = (Member) session.getAttribute("loginMember");
		
//		if(loginMember != null) {
//			List<Sudoku> sudokuGenerator = service.easyGenerator(loginMember.getMemberNo());
//			session.setAttribute("col", sudokuGenerator);
//		}
//		
		req.getRequestDispatcher("/WEB-INF/views/play/easy.jsp").forward(req, resp);
		
	}
	
}
