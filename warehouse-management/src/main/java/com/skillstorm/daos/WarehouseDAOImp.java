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
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
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
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
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
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
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
		
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
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

}
