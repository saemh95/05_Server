package edu.kh.sudoku.play.model.service;

import static edu.kh.sudoku.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.sudoku.play.model.dao.PlayDAO;
import edu.kh.sudoku.play.model.dto.Sudoku;
public class PlayService {

	private PlayDAO dao = new PlayDAO();
	
	public List<Sudoku> easyGenerator(String memberNo) {

		Connection conn = getConnection();
		List<Sudoku> sudokuGenerator = dao.easyGenerator(conn, memberNo);
		
		close(conn);
		
		return sudokuGenerator;
	}

}
