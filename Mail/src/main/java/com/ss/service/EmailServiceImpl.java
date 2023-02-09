package com.ss.service;

import java.io.File;
import java.time.LocalDateTime;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ss.entity.Email;
import com.ss.request.EmailRequest;
import com.ss.response.EmailResponse;

@Service
public class EmailServiceImpl implements EmailServices {
	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public EmailResponse send(EmailRequest emailRequest) {
		EmailResponse emailResponse = new EmailResponse();
		String path = emailRequest.getAttachmentPath();
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom("rajguruv737@gmail.com");
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailRequest.getToEmail()));
			mimeMessage.addRecipients(Message.RecipientType.CC, InternetAddress.parse(emailRequest.getCc()));
			mimeMessage.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(emailRequest.getBcc()));
			mimeMessageHelper.setText(emailRequest.getBody());
			mimeMessageHelper.setSubject(emailRequest.getSubject());
			FileSystemResource fileSystemResource = new FileSystemResource(new File(path));
			mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
			javaMailSender.send(mimeMessage);
			emailResponse.setSendTime(LocalDateTime.now());
			emailResponse.setSender("rajguruv737@gmail.com");
			emailResponse.setStatus("Successfully send");
		} catch (MessagingException e) {

			emailResponse.setStatus(e.getMessage());
		}

		return emailResponse;
	}

}
