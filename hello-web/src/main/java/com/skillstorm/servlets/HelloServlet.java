package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.models.Artist;

// Need to tell TomCat about my Servlet
@WebServlet(urlPatterns = "/hello") // This is an annotation parameter
public class HelloServlet extends HttpServlet{

	private static final long serialVersionUID = -5590522137436265416L;

	// Handle get request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Servlet!");
		
		// 1. Send the message itself
		// 2. Redirect them to the HTML page
		//resp.getWriter().write("<h1>Hello Servlet!</h1");
		resp.sendRedirect("public/pages/index.html");
		//resp.setStatus(200);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Post!");
		// Using Jackson we can parse the request body for the data to create An Artist
		
		// Using JSON
		ObjectMapper mapper = new ObjectMapper();
		InputStream reqBody = req.getInputStream();
		
		// pass the inputstream as well as the class of the object to translate to
		Artist artist = mapper.readValue(reqBody, Artist.class);
		System.out.println(artist);
		
		// Send back the updated object as JSON
		//resp.setHeader("Content-Type", "application/json");
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(artist));
		
		
		// Using HTML Forms
		
	}
}
