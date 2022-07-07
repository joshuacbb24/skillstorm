package com.skillstorm.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class LoggingFilter implements Filter {
	
	// Filters must override the ability to filter a request
	// request + response are the HTTP req and resp
	// FilterChain is so that we can continue to the next item in the chain
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		//Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//Filter.super.destroy();
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Commencing LogginFilter logs");
		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocale());
		System.out.println("Filter complete. Commencing chain");
		chain.doFilter(request, response);
	}

	
}
