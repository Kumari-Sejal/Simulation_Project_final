package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.MenuItem;
import com.cognizant.repository.MenuRepo;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepo menuRepo;

	@Override
	public List<MenuItem> getAllProducts() {

		List<MenuItem> listOfProducts = menuRepo.findAll();
		return listOfProducts;

	}

	@Override
	public MenuItem getProductById(int id) {
		  MenuItem menuItem = menuRepo.findById(id).orElse(null);
		  return menuItem;
	}

	@Override
	public MenuItem createMenu(MenuItem menuItem) {
		MenuItem menu = menuRepo.save(menuItem);
		return menu;
	}

	@Override
	public MenuItem updateMenu(int id, MenuItem menuItem) {
		 
		MenuItem menu = getProductById(id);
		
		if(menu == null)
		{
			menu = new MenuItem();
		}
		 
		 menu.setPrice(menuItem.getPrice());
		 menu.setName(menuItem.getName());
		 menu.setActive(menuItem.isActive());
		 menu.setMenuId(menuItem.getMenuId());
		 
		 MenuItem updatedMenu = menuRepo.save(menu);
		 return updatedMenu;
		 
		 
		 
	}

	@Override
	public String deleteMenu(int id) {
		menuRepo.deleteById(id);
		return "Deleted";
	}

	
	
	
	

}
