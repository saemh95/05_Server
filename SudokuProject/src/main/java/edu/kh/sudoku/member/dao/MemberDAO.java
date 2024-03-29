package edu.kh.sudoku.member.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.sudoku.member.dto.Member;
import static edu.kh.sudoku.common.JDBCTemplate.*;

public class MemberDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private Properties prop;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/sudoku/sql/member_sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
//			System.out.println(filePath);
		} catch (Exception e) {
			System.out.println("[Member_sql.xml Connection Error]");
			e.printStackTrace();
		}
	}
	
	public Member login(Connection conn, String inputId, String inputPw) {

		Member loginMember = null;
		try {
//			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement("SELECT MEMBER_NO, MEMBER_ID, MEMBER_NAME, TO_CHAR(ENROLL_DATE, 'YYYY\"년\" MM\"월\" DD\"일\" HH24\"시\" MI\"분\" SS\"초\"') AS ENROLL_DATE FROM \"MEMBER\" WHERE MEMBER_ID = ? AND MEMBER_PW = ? AND MEMBER_DEL_FL = 'N'");
//			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			rs = pstmt.executeQuery();
//			System.out.println("rs : " + rs);
//			System.out.println("id : " + inputId);
//			System.out.println("pw : "+ inputPw);
			if(rs.next()) {
				loginMember = new Member();
				String memberNo = rs.getString("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NAME");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				
//				System.out.println("memberNo : " + memberNo);
				System.out.println("id : " + memberId);
//				System.out.println("pw : " + inputPw);
				
				
				loginMember.setMemberId(memberId);
				loginMember.setMemberNo(memberNo);
				loginMember.setMemberName(memberName);
				loginMember.setEnrollDate(enrollDate);
			} else {
				System.out.println("error");
			}
//			System.out.println(loginMember);
		} catch (Exception e) {
			System.out.println("[Member login DAO error]");
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return loginMember;
	}

	public int signup(Connection conn, Member member) {

		int result = 0 ;
		
		try {
			String sql = prop.getProperty("signup");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("[Signup DAO error]");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

}
