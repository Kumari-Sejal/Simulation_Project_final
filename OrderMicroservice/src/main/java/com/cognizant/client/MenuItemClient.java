package com.cognizant.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.MenuItem;

@FeignClient(name = "menuservice", url = "localhost:8080/menuitem")
public interface MenuItemClient {

	@GetMapping("/getallproducts")
	public List<MenuItem> getAllProducts(@RequestHeader(name = "Authorization") String token);

	@GetMapping("/getproductbyid/{id}")
	public MenuItem getProductById(@RequestHeader(name = "Authorization") String token, @PathVariable("id") int id);

}
