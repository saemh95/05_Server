package edu.kh.todolist.member.controller;

import java.io.IOException;

import edu.kh.todolist.member.model.dto.Member;
import edu.kh.todolist.member.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			
			MemberService service = new MemberService();
			
			Member member = new Member();
			
			member.setMemberId(inputId);
			member.setMemberPw(inputPw);
			member.setMemberNickname(inputName);
			
			int result = service.signUp(member);
			
			HttpSession session = req.getSession();
			
			if (result>0) {
				session.setAttribute("message", "singup completed");
				resp.sendRedirect("/");
			} else {
				session.setAttribute("message", "signup error");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
		} catch (Exception e) {

			System.out.println("[Signup Error]");
			e.printStackTrace();
		}
	}
	
}
