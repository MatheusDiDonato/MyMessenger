package com.java.mail.javamail.utils;

import com.java.mail.javamail.domain.EmailEntity;
import com.java.mail.javamail.dto.EmailDto;
import com.java.mail.javamail.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmailUtils {
    private final EmailService emailService;

    public void enviaListaDeEmail(@Valid EmailDto emailDto){

         emailDto.getEmailTo().forEach(e -> {
             log.info("[API - MyMessenger] - INICIANDO FOREACH PARA ENVIAR MULTIPLOS EMAILS ");
            emailService.sendEmail(EmailEntity.builder()
                            .emailTo(e)
                    .bodyHtml(emailDto.getBodyHtml())
                    .subject(emailDto.getSubject())
                    .text(emailDto.getText()).build()
            );
        });

    }
}
