package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/condition")
public class JSTLConditonController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("name", "squid");
		req.setAttribute("money", 50000);
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/jstl/condition.jsp");
		dis.forward(req, resp);
		
	}
	
}
