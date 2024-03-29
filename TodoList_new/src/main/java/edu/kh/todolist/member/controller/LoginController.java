package edu.kh.todolist.member.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todolist.member.model.dto.Member;
import edu.kh.todolist.member.service.MemberService;
import edu.kh.todolist.todo.model.dto.ToDo;
import edu.kh.todolist.todo.service.TodoService;
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
								
				TodoService todoService = new TodoService();
				
				List<ToDo> todoList = todoService.SelectAll(loginMember.getMemberNo());
				
				session.setAttribute("todoList", todoList);
				
				resp.sendRedirect("/");
				
			} else {
				
				session.setAttribute("message", "Incorrect ID / Password");
				String referer = req.getHeader("referer");
				resp.sendRedirect(referer);
			}
			
			
			
		} catch (Exception e) {
			System.out.println("[Login Error]");
			e.printStackTrace();
		}
		
	}
	
}
