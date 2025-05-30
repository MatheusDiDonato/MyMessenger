package com.java.mail.javamail.tarefasAgendadas;

import com.java.mail.javamail.domain.EmailEntity;
import com.java.mail.javamail.repository.EmailRepository;
import com.java.mail.javamail.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class EnviarEmailAgendado {

    private final EmailService emailService;
    private final EmailRepository emailRepository;

    @Scheduled(fixedDelay = 1000 * 300)
    public void enviaEmailAutomatico() {
        log.info("[API-MESSENGER] - ATIVANDO TAREFA AGENDADA DE 5 MINUTOS PARA EMAILS QUE DERAM PROBLEMA NO ENVIO {}", LocalDateTime.now());
        List<EmailEntity> emailsNaoEnviados = emailRepository.findEmailEntityByStatus();

        emailsNaoEnviados.forEach(emailService::sendEmail);
    }
}
