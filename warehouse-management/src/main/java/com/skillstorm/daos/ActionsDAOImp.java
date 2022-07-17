package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
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
		
		
		String sql = "select activity.user, message.action_message from activity inner join message ON activity.code=message.code";
		try {
			Connection conn = DriverManager.getConnection(creds.getUrl(), creds.getUsername(), creds.getPassword());
			
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

}
