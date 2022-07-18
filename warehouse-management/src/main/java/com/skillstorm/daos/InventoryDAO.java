package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Inventory;

public interface InventoryDAO {

	// CRUD: create, read, update, delete
	
	public Inventory findById(int id);
	public List<Inventory> findInvByBuildingId(int id);
	public List<Inventory> findAll();
	//public Inventory findByName(String name);
	public Inventory save(Inventory item);
	public void update(Inventory item); // contains the id and updates as needed
	//public void delete(Inventory item);
	public void delete(int id);
	public void deleteMany(int[] id);
}
