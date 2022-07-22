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
import com.skillstorm.models.Action;

public class ActionsDAOImp implements ActionsDAO{
	
	
		WarehouseDbCreds creds = WarehouseDbCreds.getInstance();

	@Override
	public List<Action> findAll() {
		
		
		String sql = "select activity.user, message.action_message from activity inner join message on activity.code=message.code order by activity_id desc";
		try (Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			LinkedList<Action> actions = new LinkedList<>();
			
			// next() returns a boolean on whether the iterator is done yet
			// You need to advance the cursor with it so that you can parse all of the results
			while(rs.next()) {
				// looping over rows
				Action action = new Action(rs.getString("action_message"), rs.getString("user"));
				actions.add(action);
			}
			
			return actions;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(int code, String name) {
		String sql = "insert into activity (code, user) values (?, ?)";
		
		try(Connection conn = WarehouseDbCreds.getInstance().getConnection()){
			
			conn.setAutoCommit(false); // Prevents each query from immediately altering the database
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, code);
			ps.setString(2, name);
			
			int rowsAffected = ps.executeUpdate();
			
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
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
