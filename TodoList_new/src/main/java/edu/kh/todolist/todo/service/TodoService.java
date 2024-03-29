package edu.kh.todolist.todo.service;

import static edu.kh.todolist.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.todolist.todo.model.dao.TodoDAO;
import edu.kh.todolist.todo.model.dto.ToDo;

public class TodoService {

	private TodoDAO dao = new TodoDAO();
	
	public List<ToDo> SelectAll(String memberNo) {

		Connection conn = getConnection();
		
		List<ToDo> todoList = dao.selectAll(conn, memberNo);
		
		close(conn);
		
		return todoList;
	}

	public int insert(String title, String memo, String memberNo) {
		
		int result = 0;
		
		Connection conn = getConnection();
		
		result = dao.insert(conn, title, memo, memberNo);
		
		if (result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
		
	}

	public int delete(String todoNo) {

		int result = 0;
		
		Connection conn = getConnection();
		System.out.println("todoService : " + todoNo);
		result = dao.delete(conn, todoNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public ToDo selectOne(String todoNo, String memberNo) {

		Connection conn = getConnection();
		ToDo todo = dao.selectOne(conn, todoNo, memberNo);
		
		close(conn);
		
		return todo;
	}

	public int update(String title, String memo, String todoNo) {

		int result = 0;
		
		Connection conn = getConnection();
		
		result = dao.update(conn, title, memo, todoNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}

}
