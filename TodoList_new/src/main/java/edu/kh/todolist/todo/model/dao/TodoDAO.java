package edu.kh.todolist.todo.model.dao;

import static edu.kh.todolist.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todolist.member.model.dto.Member;
import edu.kh.todolist.todo.model.dto.ToDo;
public class TodoDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public TodoDAO() {
		try {
			prop = new Properties();
			
			String filePath = TodoDAO.class.getResource("/edu/kh/todolist/sql/todo_sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	public List<ToDo> selectAll(Connection conn, String memberNo) {

		List<ToDo> todoList = new ArrayList<ToDo>();
		
		try {
			String sql = prop.getProperty("selectAll");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ToDo todo = new ToDo();
				int todoNo = rs.getInt("TODO_NO");
				String todoTitle = rs.getString("TODO_TITLE");
				String todoMemo = rs.getString("TODO_MEMO");
				String todoDate = rs.getString("TODO_DATE");
				
				todo.setTodoNo(todoNo);
				todo.setTodoTitle(todoTitle);
				todo.setTodoMemo(todoMemo);
				todo.setTodoDate(todoDate);
				
				todoList.add(todo);
			}
			
		} catch(Exception e) {
			System.out.println("[DAO error]");
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
//		System.out.println(todoList);
		return todoList;
	}

	public int insert(Connection conn, String title, String memo, String memberNo) {

		int result = 0;
		
		try {
			String sql = prop.getProperty("insert");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, memo);
			pstmt.setString(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println("[Insert DAO error]");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int delete(Connection conn, String todoNo) {
		
		int result = 0;
		
		try {
			System.out.println(todoNo);
			System.out.println("DAO");
			//String sql = prop.getProperty("delete");
			String sql = "UPDATE TODO SET TODO_DEL_FL = 'Y' WHERE TODO_NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, todoNo);
			
			result = pstmt.executeUpdate();
			System.out.println("todoDAO : " + result);
		} catch (Exception e) {
			System.out.println("[Delete DAO error]");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ToDo selectOne(Connection conn, String todoNo, String memberNo) {

		ToDo todo = null;
		
		try {
			String sql = prop.getProperty("update");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			pstmt.setString(2, todoNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String todoTitle = rs.getString("TODO_TITLE");
				String todoMemo = rs.getString("TODO_MEMO");
				String todoDate = rs.getString("TODO_DATE");
				int todoNo1 = rs.getInt("TODO_NO");
				
				todo = new ToDo();
				todo.setTodoDate(todoDate);
				todo.setTodoMemo(todoMemo);
				todo.setTodoTitle(todoTitle);
				todo.setTodoNo(todoNo1);
			}
		} catch (Exception e) {

			System.out.println("[Update DAO error]");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return todo;
	}

	public int update(Connection conn, String title, String memo, String todoNo) {

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateCommit");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, memo);
			pstmt.setString(3, todoNo);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[Update 2 DAO error]");
		}
		return result;
	}

}
