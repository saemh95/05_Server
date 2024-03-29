package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/student/searchDept")
public class SearchDeptController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		StudentService service = new StudentService();
		String deptName = req.getParameter("deptName");
		
		List<Student> stdList = new ArrayList<Student>();
		try {
			stdList = service.searchDept(deptName);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("controller" + stdList);
		req.setAttribute("stdList", stdList);
		req.getRequestDispatcher("/WEB-INF/views/student/searchDept.jsp").forward(req, resp);
	}
	
}
