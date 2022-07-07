package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Artist;

//Queries specific to artist
public interface ArtistDAO {

	// CRUD: create, read, update, delete
	
	public List<Artist> findAll();
	public Artist findById(int id);
	public Artist findByName(String name);
	public Artist save(Artist artist);
	public void update(Artist artist); // contains the id and updates as needed
	public void delete(Artist artist);
	public void delete(int id);
	public void deleteMany(int[] id);
}
