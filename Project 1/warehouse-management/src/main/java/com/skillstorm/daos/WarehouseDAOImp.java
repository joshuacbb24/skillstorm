package com.skillstorm.daos;


import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.skillstorm.conf.WarehouseDbCreds;
import com.skillstorm.models.Warehouse;

public class WarehouseDAOImp implements WarehouseDAO{

	WarehouseDbCreds creds = WarehouseDbCreds.getInstance();
	
	@Override
	public List<Warehouse> getAll() {
		/*		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			
		}
		*/
		String sql = "select * from building";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// looping over rows
				Warehouse warehouse = new Warehouse(rs.getInt("building_id"), rs.getString("building_name"), rs.getInt("company_id"), rs.getInt("capacity"), rs.getInt("stock"), rs.getInt("favorited"));
				warehouses.add(warehouse);
			}
			
			return warehouses;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Warehouse> getFavorited() {
		/*		try (Connection conn = ChinookDbCreds.getInstance().getConnection()) {
			
		} catch (SQLException e) {
			
		}
		*/
		String sql = "select * from building where favorited = 1";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Warehouse> warehouses = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// looping over rows
				Warehouse warehouse = new Warehouse(rs.getInt("building_id"), rs.getString("building_name"), rs.getInt("company_id"), rs.getInt("capacity"), rs.getInt("stock"), rs.getInt("favorited"));
				warehouses.add(warehouse);
			}
			
			return warehouses;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Warehouse findById(int id) {
		String sql = "select * from building where building_id = " + id;
		
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return new Warehouse(rs.getInt("building_id"), rs.getString("building_name"), rs.getInt("company_id"), rs.getInt("capacity"), rs.getInt("stock"), rs.getInt("favorited"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Warehouse findByName(String name) {
		String sql = "select * from building where name = ?";
		
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name); // This auto escapes any malicious characters
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Warehouse(rs.getInt("building_id"), rs.getString("building_name"), rs.getInt("company_id"), rs.getInt("capacity"), rs.getInt("stock"), rs.getInt("favorited"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void updateStock(Warehouse warehouse, int quantity) {
		String sql = "update building set stock = ? where building_id = ?";
		
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			
			// Start a transaction
			conn.setAutoCommit(false); // Prevents each query from immediately altering the database
			
			// Obtain auto incremented values like so
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, quantity);
			ps.setInt(2, warehouse.getId());

			
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
	public void update(Warehouse warehouse) {
		String sql = "update building set favorited = ? where building_id = ?";
		
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, warehouse.getFavorited());
			ps.setInt(2, warehouse.getId());
			
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
