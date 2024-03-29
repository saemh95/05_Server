package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Tomcat9 < x = korean characters could not encode
//		data character encoding -> server
		
//		req.setCharacterEncoding("UTF-8"); -> tomcat10 > no need
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw");
		String inputName = req.getParameter("inputName");
		String intro = req.getParameter("intro");
		
		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(inputName);
		System.out.println(intro);
		
		
		RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/views/result.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	
	
}
