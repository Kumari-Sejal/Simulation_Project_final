package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.client.AuthClient;
import com.cognizant.entity.Cart;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.MenuItem;
import com.cognizant.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AuthClient authclient;


	@PostMapping("/additems")
	public ResponseEntity<?> addCart(@RequestHeader(name = "Authorization") String token, @RequestBody Cart cart) {

		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(orderService.addCart(token,cart), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		
		
		//MenuItem menu = orderService.addCart(token,cart);
		//return menu;

	}

	@DeleteMapping("/deleteitems/{userid}/{menuid}")
	public ResponseEntity<?> deleteCart(@RequestHeader(name = "Authorization") String token, @PathVariable("userid") int userId,
			@PathVariable("menuid") int menuId) {
		System.out.println("Entered");
		
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(orderService.deleteCart(token,userId,menuId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		//String deleteCart = orderService.deleteCart(token,userId, menuId);
		//return deleteCart;
	}

	@GetMapping("/getallmenus")
	public ResponseEntity<?> getAllMenuItems(@RequestHeader(name = "Authorization") String token) {
		//List<MenuItem>
		
		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>( orderService.getAllMenuItems(token), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		//List<MenuItem> allMenuItems = orderService.getAllMenuItems(token);
		//return allMenuItems;
	}

	@GetMapping("/getallcarts")
	public ResponseEntity<?> getAllCartItems(@RequestHeader(name = "Authorization") String token) {

		AuthResponse authResponse = authclient.verifyToken(token);
		
		if (authResponse.isValid()) {
			return new ResponseEntity<>(orderService.getAllCartItems(token), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PLease use token to acess", HttpStatus.FORBIDDEN);
		}

		//List<Cart> allCartItems = orderService.getAllCartItems(token);
		//return allCartItems;
	}

}
