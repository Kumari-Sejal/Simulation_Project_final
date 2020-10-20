package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.client.AuthClient;
import com.cognizant.entity.MenuItem;
import com.cognizant.model.AuthResponse;
import com.cognizant.service.MenuService;

@RestController
@RequestMapping("/menuitem")
public class MenuController {

	@Autowired
	private MenuService menuServiceImpl;
	
	@Autowired
	private AuthClient authclient;

	@GetMapping("/getallproducts")
	public ResponseEntity<?> getAllProducts(@RequestHeader(name = "Authorization") String token) {
		
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuServiceImpl.getAllProducts(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		
	}

	@GetMapping("/getproductbyid/{id}")
	public ResponseEntity<?> getProductById(@RequestHeader(name = "Authorization") String token, @PathVariable("id") int id) {
		
		
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuServiceImpl.getProductById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
			
			//MenuItem menuItem = menuServiceImpl.getProductById(id);
			//return menuItem;

		}
	}

	@PostMapping("/createmenu")
	public ResponseEntity<?> createMenu(@RequestHeader(name = "Authorization") String token, @RequestBody MenuItem menuItem) {
		
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuServiceImpl.createMenu(menuItem), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}
		//MenuItem menu = menuServiceImpl.createMenu(menuItem);
		//return menu;
	}

	@PutMapping("/updatemenu/{menuId}")
	public ResponseEntity<?> updateMenu(@RequestHeader(name = "Authorization") String token, @PathVariable("menuId") int menuId,
			@RequestBody MenuItem menuItem) {
		
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuServiceImpl.updateMenu(menuId,menuItem), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		
		//MenuItem updateMenu = menuServiceImpl.updateMenu(menuId, menuItem);
		//return updateMenu;
	}

	@DeleteMapping("/deletemenu/{id}")
	public ResponseEntity<?> deleteMenu(@RequestHeader(name = "Authorization") String token, @PathVariable("id") int id) {
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(menuServiceImpl.deleteMenu(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		
		//String deleteMenu = menuServiceImpl.deleteMenu(id);
		//return deleteMenu;
	}

}
