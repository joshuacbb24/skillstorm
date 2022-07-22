package com.skillstorm.daos;

import java.util.List;

import com.skillstorm.models.Action;

public interface ActionsDAO {

	public List<Action> findAll();
	public void insert(int code, String user);
}
