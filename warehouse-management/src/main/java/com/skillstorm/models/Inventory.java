package com.skillstorm.models;

public class Inventory {

	private int id;
	private int buildingId;
	private String buildingName;
	private String name;
	private int quantity;
	private String date;
	
	
	public Inventory() {
		super();
	}


	public Inventory(int id, int buildingId, String buildingName, String name, int quantity) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.name = name;
		this.quantity = quantity;
	}


	public Inventory(int id, int buildingId, String buildingName, String name, int quantity, String date) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.name = name;
		this.quantity = quantity;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBuildingId() {
		return buildingId;
	}


	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	@Override
	public String toString() {
		return "Inventory [id=" + id + ", buildingId=" + buildingId + ", buildingName=" + buildingName + ", name="
				+ name + ", quantity=" + quantity + ", date=" + date + "]";
	}



	


	

	
	
	
}
