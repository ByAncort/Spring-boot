package com.app.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }

    // Método para enviar correo a uno o más destinatarios
    public void sendEmail(String[] recipients, String body, String subject) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmailId);
        simpleMailMessage.setTo(recipients); // Acepta múltiples destinatarios
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);
        javaMailSender.send(simpleMailMessage);
    }
}
