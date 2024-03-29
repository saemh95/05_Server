package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {

	private StudentDAO dao = new StudentDAO();
	
	
	public List<Student> selectAll() throws Exception{
		
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectAll(conn);
		
//		System.out.println("service" + stdList);
		close(conn);
		
		return stdList;
	}


	public List<Student> selectArch() throws Exception{

		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectArch(conn);
		
		close(conn);
		
		return stdList;
	}

	public List<Student> searchDept(String deptName) throws Exception{
		
		Connection conn = getConnection();
		
		List<Student> stdList = dao.searchDept(conn, deptName);
		
		return stdList;
	}
	
}
