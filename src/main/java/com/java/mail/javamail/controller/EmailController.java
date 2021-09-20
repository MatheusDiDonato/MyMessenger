package com.java.mail.javamail.controller;

import com.java.mail.javamail.domain.EmailEntity;
import com.java.mail.javamail.dto.EmailDto;
import com.java.mail.javamail.service.EmailService;
import com.java.mail.javamail.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;
    private final EmailUtils emailUtils;

    @PostMapping(value = "/enviar-email")
    public ResponseEntity<EmailDto> enviarEmail(@RequestBody @Valid EmailDto emailDto){
        emailUtils.enviaListaDeEmail(emailDto);
        return ResponseEntity.ok().body(emailDto);
    }
}
