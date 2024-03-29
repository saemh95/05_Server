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
import edu.kh.sudoku.menu.model.dto.Menu;
import edu.kh.sudoku.play.model.dto.Play;

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

}
