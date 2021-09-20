package com.java.mail.javamail.tarefasAgendadas;

import ch.qos.logback.core.util.FixedDelay;
import com.java.mail.javamail.domain.EmailEntity;
import com.java.mail.javamail.dto.EmailDto;
import com.java.mail.javamail.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class EnviarEmailAgendado {

    private final EmailService emailService;
    @Scheduled(fixedDelay = 1000 * 60)

    public void enviaEmailAutomatico(){

        log.info("[API-MESSENGER] - ATIVANDO TAREFA AGENDADA DE 1 MINUTO {}", LocalDateTime.now());
        emailService.sendEmail(
                EmailEntity.builder()
                        .emailTo("*********@gmail.com")
                        .subject("teste de envio a cada minuto")
                        .text("teste de envio a cada minuto").build()
        );
    }
}
