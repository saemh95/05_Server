package edu.kh.sudoku.play.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import edu.kh.sudoku.play.model.dto.Sudoku;
import static edu.kh.sudoku.common.JDBCTemplate.*;
public class PlayDAO {

	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties prop;
	
	public PlayDAO() {
		
		prop = new Properties();
		String filePath = PlayDAO.class.getResource("/edu/kh/sudoku/sql/play_sql.xml").getPath();
		try {
			
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (Exception e) {

			System.out.println("[Play DAO XML error]");
			e.printStackTrace();
		}
		
	}
	
	public List<Sudoku> easyGenerator(Connection conn, String memberNo) {

		List<Sudoku> sudokuGenerator = null;
		
		try {
			
			String sql = prop.getProperty("easy");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String numbers = rs.getString("NUMBERS");
				Sudoku sudoku = new Sudoku();
				sudoku.setNumbers(numbers);
				sudokuGenerator.add(sudoku);
			}
			
		} catch (Exception e) {

			System.out.println("[easy generator DAO error]");
			e.printStackTrace();
		} finally {
			close(rs);
			close(conn);
		}
		return sudokuGenerator;
	}

}
