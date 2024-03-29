package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ExampleController5 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("inpName1");
		String pw = req.getParameter("inpPw1");
		
//		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/view/test.jsp");
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/test.jsp");
		dispacher.forward(req, resp);
		
	}
	
}
