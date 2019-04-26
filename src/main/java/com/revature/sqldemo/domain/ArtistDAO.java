package com.revature.sqldemo.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {
	private Connection conn;
	
	public ArtistDAO(Connection conn) {
		this.conn = conn;
	}

	public List<Artist> getAll() {
		String sql = "SELECT * FROM artists";
		List<Artist> artists = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				artists.add(new Artist((rs.getInt("id")), rs.getString("name")));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
	}
}
