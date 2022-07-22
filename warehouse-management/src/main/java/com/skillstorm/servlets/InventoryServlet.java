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
import com.skillstorm.daos.WarehouseDAO;
import com.skillstorm.daos.WarehouseDAOImp;
import com.skillstorm.models.Inventory;
import com.skillstorm.models.NotFound;
import com.skillstorm.models.Warehouse;
import com.skillstorm.services.URLParserService;

@WebServlet(urlPatterns = "/inventory/*")
public class InventoryServlet extends HttpServlet {

	private static final long serialVersionUID = 6624045737784858661L;
	InventoryDAO dao = new InventoryDAOImp();
	WarehouseDAO warehouseDao = new WarehouseDAOImp();
	ObjectMapper mapper = new ObjectMapper();
	URLParserService urlService = new URLParserService();

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
		int stock = 0;
		// Using Jackson we can parse the request body for the data to create an Artist

		// Using JSON
		InputStream reqBody = req.getInputStream();

		Inventory item = mapper.readValue(reqBody, Inventory.class);
		System.out.println(item);
		try {
			dao.save(item);
			List<Inventory> inventory = dao.findInvByBuildingId(item.getBuildingId());

			for (Inventory item1 : inventory) {
				stock = stock + item1.getQuantity();
			}
			Warehouse warehouse = warehouseDao.findById(item.getBuildingId());
			warehouseDao.updateStock(warehouse, stock);
			

		} catch (Exception e) {
			e.printStackTrace();
		}


		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(item));

	}

	@Override
	// A method that is called when a HTTP PUT request is sent to the servlet.
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int stock = 0;
			InputStream reqBody = req.getInputStream();
			Inventory item = mapper.readValue(reqBody, Inventory.class);
			// Checking to see if the item is null. If it is null, it will return a 404 error.
			if (item != null) {
				System.out.println("editing " + item);
				int id = item.getId();
				Inventory item2 = dao.findById(id); 
				dao.update(item, item2);
				// Finding all the inventory items in the database that have the same building id as the item that
				// was just added.
				List<Inventory> inventory = dao.findInvByBuildingId(item.getBuildingId());

				// Looping through the inventory list and adding the quantity of each item to the stock variable.
				for (Inventory item1 : inventory) {
					stock = stock + item1.getQuantity();
				}
				Warehouse warehouse = warehouseDao.findById(item.getBuildingId());
				warehouseDao.updateStock(warehouse, stock);
				
				stock = 0;
				
				List<Inventory> inventory1 = dao.findInvByBuildingId(item.getOldBuildingId());

				// Looping through the inventory list and adding the quantity of each item to the stock variable.
				for (Inventory item1 : inventory1) {
					stock = stock + item1.getQuantity();
				}
				
				Warehouse warehouse1 = warehouseDao.findById(item.getOldBuildingId());
				warehouseDao.updateStock(warehouse1, stock);
								
				resp.setStatus(200);
				resp.setContentType("application/json");
				resp.getWriter().print(mapper.writeValueAsString(item));
			} else {
				resp.setStatus(404);
				resp.getWriter()
						.print(mapper.writeValueAsString(new NotFound("No inventory with the provided Id found")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int stock = 0;
			int id = urlService.extractIdFromURL(req.getPathInfo());
			Inventory item = dao.findById(id);
			System.out.println("deleting " + item);
			// Checking to see if the item is null. If it is null, it will return a 404 error.
			if (item != null) {
				dao.delete(id);
				Warehouse warehouse = warehouseDao.findById(item.getBuildingId());
				stock = warehouse.getStock();
				stock = stock - 1;
				warehouseDao.updateStock(warehouse, stock);
				resp.setStatus(200);
				resp.setContentType("application/json");
			} else {
				resp.setStatus(404);
				resp.getWriter()
						.print(mapper.writeValueAsString(new NotFound("No inventory with the provided Id found")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
