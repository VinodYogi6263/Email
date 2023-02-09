package com.ss.request;

import com.ss.entity.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {

	private String toEmail;
	private String bcc;
	private String cc;
	private String body;
	private String attachmentPath;
	private String subject;
	

}
