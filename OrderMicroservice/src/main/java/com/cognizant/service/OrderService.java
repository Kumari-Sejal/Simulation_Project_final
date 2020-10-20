package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Cart;
import com.cognizant.model.MenuItem;

public interface OrderService {

	public List<MenuItem> getAllMenuItems(String token);

	public List<Cart> getAllCartItems(String token);

	public MenuItem addCart(String token,Cart cart);

	public String deleteCart(String token,int userId, int menuId);

}
