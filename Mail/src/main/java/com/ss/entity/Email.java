package com.ss.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
	private String toEmail;
	private String bcc;
	private String cc;
	private String body;
	private String attachmentPath;
	private String subject;
	
	

}
