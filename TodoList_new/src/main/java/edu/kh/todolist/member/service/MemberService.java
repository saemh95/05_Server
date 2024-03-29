package edu.kh.todolist.member.service;

import static edu.kh.todolist.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.todolist.member.dao.MemberDAO;
import edu.kh.todolist.member.model.dto.Member;
import edu.kh.todolist.todo.model.dto.ToDo;

public class MemberService {

	private MemberDAO dao = new MemberDAO();

	public Member login(String inputId, String inputPw) throws Exception{

		Connection conn = getConnection();
		
		Member member = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return member;
	}

	public int signUp(Member member) {
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member);
		
		if (result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

}
