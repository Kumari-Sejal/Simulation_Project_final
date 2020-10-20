package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
