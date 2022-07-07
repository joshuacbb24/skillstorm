package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.conf.ChinookDbCreds;
import com.skillstorm.models.Artist;

public class MySQLArtistDAOImpl implements ArtistDAO{

	/*
	 * Steps for JDBC:
	 * 1. Load the JDBC Driver into memory
	 * 2. Establish a connection using said Driver object
	 * 3. Create an SQL statement
	 * 4. Use the connection object to execute the SQL statement
	 * 5. Parse the returned ResultSet object for the data we want
	 * 6. Close the connection
	 */
	ChinookDbCreds creds = ChinookDbCreds.getInstance();
	
	@Override
	public List<Artist> findAll() {
		/*		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			
		}
		*/
		String sql = "select * from artist";
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Artist> artists = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// looping over rows
				Artist artist = new Artist(rs.getInt("ArtistId"), rs.getString("Name"));
				artists.add(artist);
			}
			
			return artists;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Artist findById(int id) {
		String sql = "select * from Artist where ArtistId = " + id;
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Artist(rs.getInt(1), rs.getString(2));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Artist findByName(String name) {
		String sql = "select * from Artist where name = ?";
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name); // This auto escapes any malicious characters
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Artist(rs.getInt(1), rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Artist save(Artist artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Artist artist) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(int[] id) {
		// TODO Auto-generated method stub
		
	}
	

}
