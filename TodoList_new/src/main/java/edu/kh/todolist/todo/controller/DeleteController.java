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

@WebServlet("/delete")
public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String todoNo = req.getParameter("todoNo");
			
			TodoService service = new TodoService();
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			
			System.out.println("controller : " + todoNo);
			int result = service.delete(todoNo);
			
			System.out.println("result:::" +result);
			if(result>0) {
				List<ToDo> todoList = service.SelectAll(member.getMemberNo());
				session.setAttribute("todoList", todoList);
			} else {
				session.setAttribute("message","Todo Delete Canceled");
			}
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			System.out.println("[Todo delete error]");
			e.printStackTrace();
		}
		
	}
	
}
