package com.ss.service;

import org.springframework.stereotype.Service;

import com.ss.request.EmailRequest;
import com.ss.response.EmailResponse;
@Service
public interface EmailServices {
	public abstract EmailResponse send(EmailRequest emailRequest);
}
