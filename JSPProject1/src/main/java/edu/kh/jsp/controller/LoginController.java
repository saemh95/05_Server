package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		String message = null;
		
		if (id.equals("user01") && pw.equals("pass01")) {
			message = "login success";
		} else {
			message = "Incorrect ID or PW";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
		req.setAttribute("msg", message);
		dispatcher.forward(req, resp);
		
	}
	
}
