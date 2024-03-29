package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class Test2 extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name1");
		String age = req.getParameter("age1");
		String nat = req.getParameter("nat1");
		
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/test2.jsp");
		dis.forward(req, resp);
	}
}
