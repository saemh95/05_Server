package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class ExampleController4 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("inpName");
		String pw = req.getParameter("inpPw");
		
		System.out.println(name);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispacher.forward(req, resp);
		
	}
	
}
