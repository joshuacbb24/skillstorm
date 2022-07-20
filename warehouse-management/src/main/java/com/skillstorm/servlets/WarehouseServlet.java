package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.daos.WarehouseDAO;
import com.skillstorm.daos.WarehouseDAOImp;
import com.skillstorm.models.Inventory;
import com.skillstorm.models.Warehouse;
import com.skillstorm.models.NotFound;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/warehouse/*")
public class WarehouseServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// This allows us to write code that is run right as the servlet is created
		// You can establish any connections
		
		System.out.println("Warehouse Created!");
		super.init();
	}

	@Override
	public void destroy() {
		// If any connections were established in init
		// Terminate those connections here
		System.out.println("Warehouse Destroyed!");
		super.destroy();
	}
	
	// I would prefer filters to this
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// This method activates on ALL HTTP requests to this servlet
		System.out.println("Servicing request!");
		super.service(req, resp); // Keep this line
	}
	
	private static final long serialVersionUID = 1309976916400647686L;
	WarehouseDAO dao = new WarehouseDAOImp();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();


	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Warehouse> warehouses = dao.getAll();
		System.out.println(warehouses);
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(warehouses));
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
		Warehouse building = mapper.readValue(reqBody, Warehouse.class); 
		System.out.println(building);
		
		// Send back the updated object as JSON
//		resp.setHeader("Content-Type", "application/json");
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(building));
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
}
