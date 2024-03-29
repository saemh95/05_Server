package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExampleController1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("--- 이름, 나이를 입력받아 처리하는 코드 ---");
		
		String name = req.getParameter("inputName");
		String age = req.getParameter("inputAge");
		
		System.out.println("입력 받은 이름 : " + name);
		System.out.println("입력 받은 나이 : " + age);
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		
		out.println("<title>Server response</title>");
		
		out.println("</head>");
		out.println("<body>");
		
			out.println("<h1>");
			out.println(name + "님의 나이는" + age + "세 입니다");
			out.println("</h1>");
		
		out.println("</body>");
		out.println("</html>");
	}
	
}
