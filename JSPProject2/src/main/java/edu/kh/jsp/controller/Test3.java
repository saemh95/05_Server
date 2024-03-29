package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/test3")
public class Test3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/test3.jsp");
		dispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		
		
		
		
		session.setAttribute("name", req.getParameter("inputName"));
		session.setAttribute("age", req.getParameter("inputAge"));
		session.setAttribute("opt", req.getParameter("opt"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/test3-doPost.jsp");
		dispatcher.forward(req, resp);
	}
	
}
