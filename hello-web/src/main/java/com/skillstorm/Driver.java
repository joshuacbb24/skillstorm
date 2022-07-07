package com.skillstorm;

import java.util.List;

import com.skillstorm.daos.ArtistDAO;
import com.skillstorm.daos.MySQLArtistDAOImpl;
import com.skillstorm.models.Artist;

public class Driver {
	
	// static initializer
	/*
	static {
		try {
			// Load it into memory immediately so that I have it
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArtistDAO dao = new MySQLArtistDAOImpl();
		List<Artist> artists = dao.findAll();
		
		System.out.println(artists);
		System.out.println(dao.findById(55));
		System.out.println(dao.findByName("aC/DC"));

	}

}
