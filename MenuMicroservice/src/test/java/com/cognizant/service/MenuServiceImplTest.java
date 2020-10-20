package com.cognizant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.entity.MenuItem;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceImplTest {

	@Autowired
	private MenuServiceImpl menuService;

	@Test
	public void testGetAllProducts() {
		List<MenuItem> packages = menuService.getAllProducts();
		assertEquals(packages.get(0).getMenuId(), 2);
	}

	@Test
	public void testGetAllProductsById() {
		MenuItem menuItem = menuService.getProductById(1);
		assertEquals(menuItem.getMenuId(), 1);
	}

	@Test
	public void testCreateMenu() {
		MenuItem menuAdd = new MenuItem();
		menuAdd.setName("apple");
		menuAdd.setPrice(200);
		menuAdd.setActive(true);
		MenuItem createMenu = menuService.createMenu(menuAdd);
		assertEquals(menuAdd, createMenu);
	}

	@Test
	public void testUpdateMenu() {
		MenuItem menuAdd = new MenuItem();
		menuAdd.setName("apple");
		menuAdd.setPrice(200);
		menuAdd.setActive(true);
		MenuItem updateMenu = menuService.updateMenu(1, menuAdd);

	}

	@Test
	public void testDeleteMenu() {

		String deleteMenu = menuService.deleteMenu(1);
		assertEquals(deleteMenu, "Deleted");
	}

}
