package edu.kh.sudoku.member.model.service;


import static edu.kh.sudoku.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.sudoku.member.dao.MemberDAO;
import edu.kh.sudoku.member.dto.Member;

public class MemberService {

	private MemberDAO dao = new MemberDAO();
	
	public Member login(String inputId, String inputPw) {

		Connection conn = getConnection();
		Member member = dao.login(conn, inputId, inputPw);
		
		close(conn);
		
		return member;
	}

	public int signup(Member member) {

		int result = 0;
		Connection conn = getConnection();
		
		result = dao.signup(conn, member);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	
}
