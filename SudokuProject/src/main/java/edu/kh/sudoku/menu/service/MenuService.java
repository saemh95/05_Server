package edu.kh.sudoku.menu.service;

import java.sql.Connection;
import java.util.List;

import edu.kh.sudoku.menu.model.dao.MenuDAO;
import edu.kh.sudoku.menu.model.dto.Menu;
import edu.kh.sudoku.play.model.dto.Play;
import edu.kh.sudoku.stats.mode.dto.Stats;

import static edu.kh.sudoku.common.JDBCTemplate.*;
public class MenuService {

	private MenuDAO dao = new MenuDAO();
	
	public List<Menu> getMenu() {

		Connection conn = getConnection();
		List<Menu> menuList = dao.getMenu(conn);
		close(conn);
		return menuList;
	}

	public List<Play> getPlay() {

		Connection conn = getConnection();
		
		List<Play> playList = dao.getPlay(conn);
		
		close(conn);
		return playList;
	}

	public List<Stats> getStats(String memberNo) {

		Connection conn = getConnection();
		
		List<Stats> stats = dao.getStats(conn, memberNo);
		
		close(conn);
		return stats;
	}

}
