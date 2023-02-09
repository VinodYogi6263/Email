package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ss.request.EmailRequest;
import com.ss.response.EmailResponse;
import com.ss.service.EmailServices;

@RestController
public class EmailController {
	@Autowired
	EmailServices emailServices;

	@PostMapping("/send")
	public EmailResponse send(@RequestBody EmailRequest emailRequest) {
		return emailServices.send(emailRequest);
	}

}
