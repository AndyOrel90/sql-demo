package com.revature.sqldemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.revature.sqldemo.domain.Artist;
import com.revature.sqldemo.domain.ArtistDAO;
import com.revature.sqldemo.jdbc.ConnectionUtil;

public class App {

	public static void main(String[] args) {
		Connection singleton = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("connection.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			singleton = ConnectionUtil.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArtistDAO artistDAO = new ArtistDAO(singleton);
		List<Artist> artists = artistDAO.getAll();
		artists.forEach((i) -> System.out.println(i));
		
		try {
			singleton.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
