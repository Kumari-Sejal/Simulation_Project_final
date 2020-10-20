package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.client.MenuItemClient;
import com.cognizant.entity.Cart;
import com.cognizant.model.MenuItem;
import com.cognizant.repository.CartRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private MenuItemClient menuItemClient;

	@Override
	public MenuItem addCart(String token, Cart cart) {
		MenuItem product = menuItemClient.getProductById(token, cart.getMenuId());
		Cart saveCart = cartRepo.save(cart);
		return product;

	}

	@Override
	public String deleteCart(String token,int userId, int menuId) {

		Cart cart = new Cart();
		cart.setMenuId(menuId);
		cart.setUserId(userId);

		cartRepo.delete(cart);
		return "Cart Item Deleted";

	}

	@Override
	public List<MenuItem> getAllMenuItems(String token) {
		List<MenuItem> allProducts = menuItemClient.getAllProducts(token);
		return allProducts;
	}

	@Override
	public List<Cart> getAllCartItems(String token) {
		List<Cart> findAll = cartRepo.findAll();
		return findAll;
	}

}
