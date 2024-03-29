package edu.kh.sudoku.menu.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.sudoku.menu.service.MenuService;
import edu.kh.sudoku.play.model.dto.Play;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/play")
public class PlayController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		HttpSession session = req.getSession();
		List<Play> play = menuService.getPlay();
		session.setAttribute("play", play);
		String jsp = null;
		for (Play p : play) {
			switch(p.getName()) {
			case "EASY" : jsp = "/WEB-INF/views/play/easy.jsp";
			break;
			case "MEDIUM" : jsp = "/WEB-INF/views/play/medium.jsp";
			break;
			case "HARD" : jsp = "/WEB-INF/views/play/hard.jsp";
			break;
			default : jsp = "/WEB-INF/views/play/play.jsp";
			break;
			}
		}
//		String jsp = "/WEB-INF/views/play/play.jsp";
//		
//		if ("easy".equals("EASY")) {
//			jsp = "/WEB-INF/views/play/easy.jsp";
//		} 
		
		req.getRequestDispatcher(jsp).forward(req, resp);
	}	
	
}

//session.setAttribute("play", play);
//String jsp = null;
//for (Play p : play) {
//	switch(p.getName()) {
//	case "EASY" : jsp = "/WEB-INF/views/play/easy.jsp";
//	break;
//	case "MEDIUM" : jsp = "/WEB-INF/views/play/medium.jsp";
//	break;
//	case "HARD" : jsp = "/WEB-INF/views/play/hard.jsp";
//	break;
//	default : jsp = "/WEB-INF/views/play/play";
//	break;
//	}
//}
//
//req.getRequestDispatcher(jsp).forward(req, resp);