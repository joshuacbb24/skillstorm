package com.skillstorm.conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class WarehouseDbCreds {

	private static WarehouseDbCreds instance;
	private String url;
	private String username;
	private String password;
	
	private WarehouseDbCreds() {
		try {
			// Load it into memory immediately so that I have it
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Read the properties (key/value pairs) from the application.properties
			try (InputStream input = WarehouseDbCreds.class.getClassLoader().getResourceAsStream("application.properties")) {
				
				// Properties object
				Properties props = new Properties();
				props.load(input);
				
				//Grab out the keys that you want
				this.url = props.getProperty("db.url");
				this.username = props.getProperty("db.username");
				this.password = props.getProperty("db.password");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WarehouseDbCreds getInstance() {
		if (instance == null) {
			instance = new WarehouseDbCreds();
		}
		return instance;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
}
