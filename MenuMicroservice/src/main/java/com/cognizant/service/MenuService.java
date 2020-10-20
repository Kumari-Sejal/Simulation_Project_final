package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.MenuItem;

public interface MenuService {
	
	public List<MenuItem> getAllProducts();
	
	public MenuItem getProductById(int id);
	
	public MenuItem createMenu(MenuItem menuItem);
	
	public MenuItem updateMenu(int id,MenuItem menuItem);
	
	public String deleteMenu(int id);

}


