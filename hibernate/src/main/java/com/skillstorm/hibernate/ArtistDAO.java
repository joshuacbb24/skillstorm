package com.skillstorm.hibernate;

import java.util.Set;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.skillstorm.beans.Artist;

public class ArtistDAO {

	public Artist findById(int id){
		Session session = HelloHibernate.SESSION_FACTORY.openSession();
		Artist object = (Artist) session.get(Artist.class, id);
		return object;
	}
	
	// after the save, the artist has a generated Id
	public Artist save(Artist artist) {
		Session session = HelloHibernate.SESSION_FACTORY.openSession();
		Transaction tx = session.beginTransaction();
		session.save(artist);
		return artist; // (SQLException) (rethrow as RuntimeException)
	}
}
