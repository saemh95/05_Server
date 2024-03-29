package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.*;

import edu.kh.jsp.model.dto.Pizza;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pizzaOrder")
public class PizzaOrderController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Pizza> pizzaList = new ArrayList<Pizza>();
		
		pizzaList.add( new Pizza("Chesse Pizza", 8000));
		pizzaList.add( new Pizza("Bacon Pizza", 10000));
		pizzaList.add( new Pizza("Napolitan Pizza", 13000));
		
		String pizza = req.getParameter("pizza");
		String size = req.getParameter("size");
		String amount = req.getParameter("amount");
	
//		pizza type : cheese pizza(L)
//		amount : 2
//		total cost : 20000Won
		
//		pizza "1" -> to int
		
		Pizza p = pizzaList.get(Integer.parseInt(pizza) -1);
		String pizzaName = p.getName();
		int price = p.getPrice();
		
//		L size + 2,000
//		F size + 4,000
		
		if(size.equals("L")) price+=2000;
		if(size.equals("F")) price+=4000;
		
		int amt = Integer.parseInt(amount);
		price *= amt;
		
		req.setAttribute("pizzaName", pizzaName);
		req.setAttribute("price", price);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/pizzaResult.jsp");
		dispatcher.forward(req, resp);
	}
	
}
