package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
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

@WebServlet(urlPatterns = "/inventory/*")
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
		System.out.println("Hello POST!");
		// Using Jackson we can parse the request body for the data to create an Artist
		
		// Using JSON
		ObjectMapper mapper = new ObjectMapper(); // Use the mapper to map JSON to POJO
		InputStream reqBody = req.getInputStream();
		// Pass the InputStream as well as the class of the object to translate to
		Inventory item = mapper.readValue(reqBody, Inventory.class); 
		System.out.println(item);
		
		// Send back the updated object as JSON
//		resp.setHeader("Content-Type", "application/json");
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(item));
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
}
