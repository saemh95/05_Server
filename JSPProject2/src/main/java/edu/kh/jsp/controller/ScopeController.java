package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispacher = req.getRequestDispatcher("/WEB-INF/views/scope/scope.jsp");
		
//		1. page scope -> JPS
//		2. request scope  -> request & forward
		req.setAttribute("reqValue", "1234");
		
//		3. session scope -> 1 per browser / browser exit || session expire
		HttpSession session = req.getSession();
		session.setAttribute("sessionValue", "9999");
		
//		4. application scope -> server terminate
		ServletContext app = req.getServletContext();
		app.setAttribute("appValue", 100000);
		
		req.setAttribute("str", "request 범위에 setting");
		session.setAttribute("str", "session 범위에 setting");
		app.setAttribute("str", "application 범위에 setting");
		
		dispacher.forward(req, resp);
	}
	
}
