package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/student/selectAll")
public class StudentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		StudentService service = new StudentService();
		
		try {
			
			List<Student> studentList = service.selectAll();
			
			req.setAttribute("studentList", studentList);
//			System.out.println("controller" + studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/views/student/selectAll.jsp").forward(req, resp);
		
	}
	
}
