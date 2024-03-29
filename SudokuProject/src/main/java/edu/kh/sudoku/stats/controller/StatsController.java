package edu.kh.sudoku.stats.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.sudoku.member.dto.Member;
import edu.kh.sudoku.menu.service.MenuService;
import edu.kh.sudoku.stats.mode.dto.Stats;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/stats")
public class StatsController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuService menuService = new MenuService();
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		if(loginMember != null) {
			
			List<Stats> stats = menuService.getStats(loginMember.getMemberNo());
			System.out.println("controller : " + stats);
			session.setAttribute("stats", stats);
			req.getRequestDispatcher("/WEB-INF/views/stats/stats.jsp").forward(req, resp);;
		} else {
			session.setAttribute("message", "Stats error");
			resp.sendRedirect(req.getHeader("referer"));
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
	}
	
}
