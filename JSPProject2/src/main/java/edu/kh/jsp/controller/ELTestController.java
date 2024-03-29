package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.*;

import edu.kh.jsp.mode.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/elTest")
public class ELTestController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String inputName = req.getParameter("inputName");
//		String inputAge = req.getParameter("inputAge");
//		String opt = req.getParameter("opt");
		
		req.setAttribute("address", "서울시 중구 남대문로 120");
		req.setAttribute("score", 100);
		
		List<String> strList = new ArrayList<String>();
		strList.add("HIHIHI");
		strList.add("HEHEHE");
		strList.add("HOHOHO");
		
		req.setAttribute("strList", strList);
		
		Book book = new Book("The Little Prince", "Antoine de Saint-Exupery", 4000);
		req.setAttribute("book", book);
		
		List<String> list1 = null;
		List<String> list2 = new ArrayList<String>();
		
		req.setAttribute("list1", list1);
		req.setAttribute("list2", list2);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp");
		dispatcher.forward(req, resp);
	}
	
}
