package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.mode.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/loop")
public class JSTLLoopController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book("God Is Dead. God Remains Dead. ANd We Have Killed Him", "Fredhrch Nietzsche", 13000));
		bookList.add(new Book("Critique of Pure Reason", "Immanuel Kant", 8000));
		bookList.add(new Book("Notes From Underground", "Fyodor Dostoevsky", 10000));
		bookList.add(new Book("Dialogues Concerning Natural Religion", "David Hume", 5000));
		
		req.setAttribute("bookList", bookList);
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp");
		dis.forward(req, resp);
	}
	
}
