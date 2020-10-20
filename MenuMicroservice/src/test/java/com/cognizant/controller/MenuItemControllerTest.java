package com.cognizant.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.client.AuthClient;

import com.cognizant.entity.MenuItem;
import com.cognizant.model.AuthResponse;
import com.cognizant.service.MenuService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuItemControllerTest {
	
	@Mock
	private MenuService menuServiceImpl;
	
	@Mock
	private AuthClient authclient;
	
	@Mock
	MenuItem menu;
	
	@InjectMocks
	private MenuController menuController;
	

	@Before
	public void setup()
	{
		menu = new MenuItem();
		menu.setMenuId(1);
		menu.setName("apple");
		menu.setPrice(200);
		menu.setActive(true);
	}
	
	
	@Test
	public void testGetAllProductsPass()
	{
		Mockito.when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		ResponseEntity<?> allProducts = menuController.getAllProducts("token");
		assertNotNull(allProducts);
	}
	
	@Test
	public void testGetAllProductsById()
	{
		Mockito.when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		Mockito.when(menuServiceImpl.getProductById(1)).thenReturn(menu);
		 ResponseEntity<?> productById = menuController.getProductById ("token",1);
		assertNotNull(productById);
	}
	
	@Test
	public void testGetAllProductsFail()
	{
		Mockito.when(authclient.verifyToken("token")).thenReturn(new AuthResponse("admin", "admin", true));
		ResponseEntity<?> allProducts = menuController.getAllProducts("token");
		assertNotNull(allProducts);
	}
	
	

	
	

}