package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.dto.Student;
import static edu.kh.jsp.common.JDBCTemplate.*;

public class StudentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public StudentDAO () {
//		/JSPProject2/src/main/java/edu/kh/java/sql/student_sql.xml
		try{
			String filePath = StudentDAO.class.getResource("/edu/kh/java/sql/student_sql.xml").getPath();
//			System.out.println(filePath);
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public List<Student> selectAll(Connection conn) throws Exception{

		List<Student> stdList = new ArrayList<Student>();
		try {
			String sql = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				stdList.add(new Student(studentNo, studentName, studentAddress, departmentName));
			}
//			System.out.println("DAO" + stdList);
		} finally {
			close(stmt);
			close(rs);
		}
		
		
		return stdList;
	}


	public List<Student> selectArch(Connection conn) throws Exception{

		List<Student> stdList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("selectArch");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				stdList.add(new Student(studentNo, studentName, studentAddress, departmentName));
				
			}
			
		} finally {
			close(stmt);
			close(rs);
		}
		
		return stdList;
	}


	public List<Student> searchDept(Connection conn, String deptName) throws Exception{

		List<Student> stdList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("searchDept");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptName);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				stdList.add(new Student(studentNo, studentName, studentAddress, departmentName));
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
			
		}
		
		return stdList;
	}
	
}
