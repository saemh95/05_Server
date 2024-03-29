package edu.kh.todolist.member.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static edu.kh.todolist.common.JDBCTemplate.*;
import edu.kh.todolist.member.model.dto.Member;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	
	public MemberDAO() {
		
		try {
			prop = new Properties();
			String filePath = MemberDAO.class.getResource("/edu/kh/todolist/sql/member_sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public Member login(Connection conn, String inputId, String inputPw) throws Exception{
		
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				loginMember = new Member();
				String memberNo = rs.getString("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberNickname = rs.getString("MEMBER_NICKNAME");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				loginMember.setMemberNo(memberNo);
				loginMember.setMemberId(memberId);
				loginMember.setMemberNickname(memberNickname);
				loginMember.setEnrollDate(enrollDate);
			}
			
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return loginMember;
	}


	public int signUp(Connection conn, Member member) {

		int result = 0;
		try {
			String sql = prop.getProperty("signup");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberNickname());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("[Signup DAO error]");
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
	
}
