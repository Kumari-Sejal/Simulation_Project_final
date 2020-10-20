package com.cognizant.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.model.AuthResponse;


@FeignClient(url = "http://localhost:8083/authapp", name = "authapp")
public interface AuthClient {

	@RequestMapping(path = "/validate", method = RequestMethod.GET)
	public AuthResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
