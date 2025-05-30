package com.java.mail.javamail.service.Impl;

import com.java.mail.javamail.domain.EmailEntity;
import com.java.mail.javamail.enums.StatusEmail;
import com.java.mail.javamail.repository.EmailRepository;
import com.java.mail.javamail.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    @Override
    public EmailEntity sendEmail(EmailEntity emailEntity) {
        emailEntity.setSendDateEmail(LocalDateTime.now());
        try {
            log.info("[API - MyMessenger] - TENTATIVA PARA ENVIAR EMAIL PARA {}", emailEntity.getEmailTo());
            if (emailEntity.getBodyHtml() != null && !emailEntity.getBodyHtml().isEmpty()) {
                MimeMessage mimeMessage = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
                helper.setTo(emailEntity.getEmailTo());
                helper.setSubject(emailEntity.getSubject());
                helper.setText(emailEntity.getBodyHtml(), true); // true para HTML
                emailSender.send(mimeMessage);
            } else {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(emailEntity.getEmailTo());
                message.setSubject(emailEntity.getSubject());
                message.setText(emailEntity.getText());
                emailSender.send(message);
            }
            emailEntity.setStatusEmail(StatusEmail.SENT);
            log.info("[API - MyMessenger] - EMAIL ENVIADO PARA {}", emailEntity.getEmailTo());
        } catch (MailException | MessagingException e) {
            log.info("[API - MyMessenger] - HOUVE UM ERRO EMAIL NAO FOI ENVIADO PARA {}", emailEntity.getEmailTo());
            emailEntity.setStatusEmail(StatusEmail.ERROR);
        }finally {
          return emailRepository.save(emailEntity);
        }
    }
}
