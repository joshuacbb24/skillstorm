package com.skillstorm.models;

public class Action {

	private String action;
	private String account;
	
	
	public Action() {
		super();
	}

	public Action(String action, String account) {
		super();
		this.action = action;
		this.account = account;
	}

	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Action [action=" + action + ", account=" + account + "]";
	}


	
	
	
}
