package com.java.mail.javamail.service;

import com.java.mail.javamail.domain.EmailEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {


    EmailEntity sendEmail(EmailEntity emailEntity);
}
