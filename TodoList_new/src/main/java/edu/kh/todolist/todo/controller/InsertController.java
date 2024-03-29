package edu.kh.todolist.todo.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todolist.member.model.dto.Member;
import edu.kh.todolist.todo.model.dto.ToDo;
import edu.kh.todolist.todo.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/insert")
public class InsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			TodoService service = new TodoService();
			
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			Member member = (Member)session.getAttribute("loginMember");
			
			
			int result = service.insert(title, memo, member.getMemberNo());
			
			if(result>0) {
				session.setAttribute("message", "Todo added");
				List<ToDo> todoList = service.SelectAll(member.getMemberNo());
				session.setAttribute("todoList", todoList);
				resp.sendRedirect("/");
			} else {
				session.setAttribute("message", "Todo add error");
				resp.sendRedirect(req.getHeader("referer"));
			}
		} catch (Exception e) {
			System.out.println("[Add todo error]");
			e.printStackTrace();
		}
		
	}
	
}
