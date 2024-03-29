package edu.kh.sudoku.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.sudoku.member.dto.Member;
import edu.kh.sudoku.member.model.service.MemberService;
import edu.kh.sudoku.menu.model.dto.Menu;
import edu.kh.sudoku.menu.service.MenuService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			
			Member loginMember = service.login(inputId, inputPw);
			
			HttpSession session = req.getSession();
			if(loginMember != null) {
				session.setAttribute("loginMember", loginMember);
				session.setMaxInactiveInterval(60*60); 
				
				MenuService menuService = new MenuService();
//				Member member = (Member) session.getAttribute("loginMember");
				List<Menu> menu = menuService.getMenu();
				
				
				session.setAttribute("menu", menu);
				resp.sendRedirect("/");
				
			} else {
				session.setAttribute("message", "Incorrect ID / Password");
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
				
			}
		} catch (Exception e) {
			System.out.println("[Login Controller error]");
			e.printStackTrace();
		}
		
	}
}
