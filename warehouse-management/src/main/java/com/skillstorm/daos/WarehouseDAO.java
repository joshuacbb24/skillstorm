package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Warehouse;

public interface WarehouseDAO {

	public List<Warehouse> getAll();
	public List<Warehouse> getFavorited();
	public Warehouse findById(int id);
	public Warehouse findByName(String name);
	public void updateStock(Warehouse warehouse, int quantity);
	public void update(Warehouse warehouse);
}
