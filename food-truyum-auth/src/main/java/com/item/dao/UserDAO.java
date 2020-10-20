package com.item.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.item.model.UserTruyum;

@Repository
public interface UserDAO extends JpaRepository<UserTruyum, String> {

}
