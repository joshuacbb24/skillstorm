package com.skillstorm.models;

public class Warehouse {

	private int id;
	private String name;
	private int companyid;
	private int capacity;
	private int stock;
	private int favorited;
	
	
	public Warehouse() {
		super();
	}


	public Warehouse(String name, int companyid, int capacity, int favorited) {
		super();
		this.name = name;
		this.companyid = companyid;
		this.capacity = capacity;
		this.favorited = favorited;
	}


	public Warehouse(String name, int companyid, int capacity, int stock, int favorited) {
		super();
		this.name = name;
		this.companyid = companyid;
		this.capacity = capacity;
		this.stock = stock;
		this.favorited = favorited;
	}


	public Warehouse(int id, String name, int companyid, int capacity, int stock, int favorited) {
		super();
		this.id = id;
		this.name = name;
		this.companyid = companyid;
		this.capacity = capacity;
		this.stock = stock;
		this.favorited = favorited;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCompanyid() {
		return companyid;
	}


	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getFavorited() {
		return favorited;
	}


	public void setFavorited(int favorited) {
		this.favorited = favorited;
	}


	@Override
	public String toString() {
		return "Warehouse [id=" + id + ", name=" + name + ", companyid=" + companyid + ", capacity=" + capacity
				+ ", stock=" + stock + ", favorited=" + favorited + "]";
	}



	
}
