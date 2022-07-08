package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.conf.WarehouseDbCreds;
import com.skillstorm.models.Inventory;

public class InventoryDAOImp implements InventoryDAO{

	/*
	 * Steps for JDBC:
	 * 1. Load the JDBC Driver into memory
	 * 2. Establish a connection using said Driver object
	 * 3. Create an SQL statement
	 * 4. Use the connection object to execute the SQL statement
	 * 5. Parse the returned ResultSet object for the data we want
	 * 6. Close the connection
	 */
	WarehouseDbCreds creds = WarehouseDbCreds.getInstance();

	@Override
	public Inventory findById(int id) {
		String sql = "select * from inventory where item_id = " + id;
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Inventory(rs.getInt("item_id"), rs.getInt("building_id"), rs.getString("item_name"), rs.getString("path"), rs.getInt("quantity"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Inventory save(Inventory Inventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Inventory Inventory) {
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

	@Override
	public List<Inventory> findInvByBuildingId(int id) {
		String sql = "select * from inventory where building_id = " + id;
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Inventory> Inventorys = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// looping over rows
				Inventory Inventory = new Inventory(rs.getInt("item_id"), rs.getInt("building_id"), rs.getString("item_name"), rs.getString("path"), rs.getInt("quantity"));
				Inventorys.add(Inventory);
			}
			
			return Inventorys;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}