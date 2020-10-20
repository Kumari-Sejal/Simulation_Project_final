package com.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.item.dao.UserDAO;
import com.item.model.AuthResponse;
import com.item.model.UserLoginCredential;
import com.item.model.UserToken;
import com.item.service.CustomerDetailsService;
import com.item.service.JwtUtil;

@RestController
@RequestMapping("/authapp")
public class AuthController {

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private CustomerDetailsService custdetailservice;
	@Autowired
	private UserDAO userservice;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserLoginCredential userlogincredentials) {
		final UserDetails userdetails = custdetailservice.loadUserByUsername(userlogincredentials.getUid());
		return new ResponseEntity<>(new UserToken(userlogincredentials.getUid(), jwtutil.generateToken(userdetails)),
				HttpStatus.OK);

	}

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") final String token) {
		String token1 = token.substring(7);
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token1)) {
			res.setUid(jwtutil.extractUsername(token1));
			res.setValid(true);
			res.setName((userservice.findById(jwtutil.extractUsername(token1)).orElse(null).getUname()));

		} else
			res.setValid(false);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
