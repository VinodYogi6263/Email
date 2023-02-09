package com.ss.response;

import java.time.LocalDateTime;

import javax.mail.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailResponse {
private LocalDateTime sendTime;
private String sender;
private String status;
}
