package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String orderName = req.getParameter("orderName");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		String optArr[] = req.getParameterValues("opt");
		
		System.out.println(orderName);
		System.out.println(coffee);
		System.out.println(type);
		for(String opt : optArr) {
			System.out.println(opt);
		}
		RequestDispatcher dispatch = req.getRequestDispatcher("/WEB-INF/views/coffee.jsp");
		dispatch.forward(req, resp);
	}
	
}
