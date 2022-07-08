package com.skillstorm.models;

public class Inventory {

	private int id;
	private int buildingId;
	private String name;
	private String path;
	private int quantity;
	
	
	public Inventory() {
		super();
	}


	public Inventory(int id, int buildingId, String name, String path, int quantity) {
		super();
		this.id = id;
		this.buildingId = buildingId;
		this.name = name;
		this.path = path;
		this.quantity = quantity;
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


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public String toString() {
		return "Inventory [id=" + id + ", buildingId=" + buildingId + ", name=" + name + ", path=" + path
				+ ", quantity=" + quantity + "]";
	}

	

	
	
	
}
