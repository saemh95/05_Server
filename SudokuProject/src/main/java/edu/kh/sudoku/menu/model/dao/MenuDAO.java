package edu.kh.sudoku.menu.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.sudoku.member.dao.MemberDAO;
import edu.kh.sudoku.member.dto.Member;
import edu.kh.sudoku.menu.model.dto.Menu;
import edu.kh.sudoku.play.model.dto.Play;
import edu.kh.sudoku.stats.mode.dto.Stats;
import static edu.kh.sudoku.common.JDBCTemplate.*;
public class MenuDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private Properties prop;
	private ResultSet rs;
	
	public MenuDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/sudoku/sql/menu_sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
//			System.out.println(filePath);
		} catch (Exception e) {
			System.out.println("[Menu_sql.xml Connection Error]");
			e.printStackTrace();
		}
	}
	
	public List<Menu> getMenu(Connection conn) {
		List<Menu> menuList = null;
		try {
			menuList = new ArrayList<Menu>();
			
			String sql = prop.getProperty("getMenu");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String menuName = rs.getString("MENU_NAME");
				String menuLink = rs.getString("MENU_LINK");
				Menu menu = new Menu();
				menu.setName(menuName);
				menu.setLink(menuLink);
				menuList.add(menu);
			}
			
		} catch (Exception e) {

			System.out.println("[getMenu DAO error]");
			e.printStackTrace();
		}
		
		return menuList;
	}

	public List<Play> getPlay(Connection conn) {

		List<Play> playList = null;
		
		try {
			playList = new ArrayList<Play>();
			String sql = prop.getProperty("getPlay");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String playName = rs.getString("DIFFICULTY_NAME");
				String playLink = rs.getString("DIFFICULTY_LINK");
				
				Play play = new Play();
				play.setName(playName);
				play.setLink(playLink);
				playList.add(play);
			}
			
		} catch (Exception e) {
			System.out.println("[getPlay DAO error]");
			e.printStackTrace();
		}
		
		
		return playList;
	}

	public List<Stats> getStats(Connection conn, String memberNo) {

		List<Stats> stats = null;
		
		try {
			
			String sql = prop.getProperty("getStats");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberNo);
			rs = pstmt.executeQuery();
//			System.out.println(memberNo);
			while(rs.next()) {
				stats = new ArrayList<Stats>();
				Stats userStats = new Stats();
				String gamePlayed = rs.getString("GAMES_PLAYED");
				String shortest = rs.getString("SHORTEST");
				String longest = rs.getString("LONGEST");
				
				userStats.setGamePlayed(gamePlayed);
				userStats.setShortest(shortest);
				userStats.setLongest(longest);
				stats.add(userStats);
			}
		} catch (Exception e) {
			System.out.println("[Stats DAO error]");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("stats DAO : " + stats);
		return stats;
	}

}
