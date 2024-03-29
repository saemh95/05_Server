package edu.kh.sudoku.member.controller;

import java.io.IOException;

import edu.kh.sudoku.member.dto.Member;
import edu.kh.sudoku.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		session.invalidate();
		
		resp.sendRedirect("/");
		
	}
	
}
