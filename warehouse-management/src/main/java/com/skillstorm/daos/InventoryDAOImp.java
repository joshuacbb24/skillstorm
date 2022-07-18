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
import com.skillstorm.models.Warehouse;

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
		String sql = "select building.building_id, building.building_name as building_name, inventory.item_id, inventory.item_name, inventory.quantity, inventory.date_added from inventory inner join building on building.building_id = inventory.building_id where inventory.item_id = " + id;
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Inventory(rs.getInt("item_id"), rs.getInt("building_id"), rs.getString("building_name"), rs.getString("item_name"), rs.getInt("quantity"), rs.getString("date_added"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Inventory save(Inventory inventory) {
		String sql = "insert into inventory (building_id, item_name, quantity, date_added) values (?, ?, ?, ?)";
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			// Start a transaction
			conn.setAutoCommit(false); // Prevents each query from immediately altering the database
			
			// Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, inventory.getBuildingId());
			ps.setString(2, inventory.getName());
			ps.setInt(3, inventory.getQuantity());
			ps.setString(4, inventory.getDate());
			
			
			int rowsAffected = ps.executeUpdate(); // If 0 is returned, my data didn't save
			if (rowsAffected != 0) {
				// If I want my keys do this code
				ResultSet keys = ps.getGeneratedKeys();
				// List a of all generated keys
//				if (keys.next()) {
//					int key = keys.getInt(1); // Give me the auto generated key
//					artist.setId(key);
//					return artist;
//				}
				conn.commit(); // Executes ALL queries in a given transaction. Green button
				return null;
			} else {
				conn.rollback(); // Undoes any of the queries. Database pretends those never happened
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(Inventory inventory) {
		String sql = "update inventory set item_name = ? , quantity = ?, date_added =  ? where item_id = ?";
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			// Start a transaction
			conn.setAutoCommit(false); // Prevents each query from immediately altering the database
			
			// Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, inventory.getName());
			ps.setInt(2, inventory.getQuantity());
			ps.setString(3, inventory.getDate());
			ps.setInt(4, inventory.getId());
			
			int rowsAffected = ps.executeUpdate(); // If 0 is returned, my data didn't save
			if (rowsAffected != 0) {
				// If I want my keys do this code
				ResultSet keys = ps.getGeneratedKeys();
				// List a of all generated keys
//				if (keys.next()) {
//					int key = keys.getInt(1); // Give me the auto generated key
//					artist.setId(key);
//					return artist;
//				}
				conn.commit(); // Executes ALL queries in a given transaction. Green button
			} else {
				conn.rollback(); // Undoes any of the queries. Database pretends those never happened
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void delete(int id) {
		String sql = "delete FROM inventory where item_id = ?";
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());

			// Start a transaction
			conn.setAutoCommit(false); // Prevents each query from immediately altering the database
			
			// Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			
			int rowsAffected = ps.executeUpdate(); // If 0 is returned, my data didn't save
			if (rowsAffected != 0) {
				// If I want my keys do this code
				ResultSet keys = ps.getGeneratedKeys();
				// List a of all generated keys
//				if (keys.next()) {
//					int key = keys.getInt(1); // Give me the auto generated key
//					artist.setId(key);
//					return artist;
//				}
				conn.commit(); // Executes ALL queries in a given transaction. Green button
			} else {
				conn.rollback(); // Undoes any of the queries. Database pretends those never happened
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMany(int[] id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Inventory> findInvByBuildingId(int id) {
		String sql = "select building.building_id, building.building_name as building_name, inventory.item_id, inventory.item_name, inventory.quantity, inventory.date_added from inventory inner join building on building.building_id = inventory.building_id where building.building_id = " + id;
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Inventory> Inventorys = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// looping over rows
				Inventory Inventory = new Inventory(rs.getInt("item_id"), rs.getInt("building_id"), rs.getString("building_name"), rs.getString("item_name"), rs.getInt("quantity"), rs.getString("date_added"));
				Inventorys.add(Inventory);
			}
			
			return Inventorys;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Inventory> findAll() {
		String sql = "select building.building_id, building.building_name as building_name, inventory.item_id, inventory.item_name, inventory.quantity, inventory.date_added from inventory inner join building on building.building_id = inventory.building_id";
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Inventory> Inventorys = new LinkedList<>();
			while (rs.next()) {
				Inventory inventory = new Inventory(rs.getInt("item_id"), rs.getInt("building_id"), rs.getString("building_name"), rs.getString("item_name"), rs.getInt("quantity"), rs.getString("date_added"));
				Inventorys.add(inventory);
			}
			
			return Inventorys;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
