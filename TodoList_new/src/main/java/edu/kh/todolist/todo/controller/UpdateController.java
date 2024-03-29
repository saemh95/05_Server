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

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	private TodoService service = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			ToDo todo = service.selectOne(req.getParameter("todoNo"), member.getMemberNo());
			req.setAttribute("todo", todo);
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
		} catch (Exception e) {

			System.out.println("[Update error]");
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			
			String title = req.getParameter("title");
			String memo = req.getParameter("memo");
			String todoNo = req.getParameter("todoNo");
			
			int result = service.update(title, memo, todoNo);			
			if (result>0) {
				session.setAttribute("message", "Update confirmed");
				List<ToDo> todo = service.SelectAll(member.getMemberNo());
				
				session.setAttribute("todoList", todo);
				resp.sendRedirect("/");
			} else {
				session.setAttribute("message", "Update cancled");
				resp.sendRedirect(req.getHeader("referer"));
			}
		} catch (Exception e) {
			System.out.println("[Update post error]");

		}
		
	}
	
}
