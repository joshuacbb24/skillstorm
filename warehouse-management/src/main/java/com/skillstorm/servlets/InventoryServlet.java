package com.skillstorm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.InventoryDAO;
import com.skillstorm.daos.InventoryDAOImp;
import com.skillstorm.models.Inventory;

@WebServlet(urlPatterns = "/inventory")
public class InventoryServlet extends HttpServlet{

	private static final long serialVersionUID = 6624045737784858661L;
	InventoryDAO dao = new InventoryDAOImp();
	ObjectMapper mapper = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Inventory> inventories = dao.findAll();
		System.out.println(inventories);
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(inventories));
		System.out.println("got here");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
