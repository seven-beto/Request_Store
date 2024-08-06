package com.example.TrainingJunior.services;

import com.example.TrainingJunior.dtos.EmailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public ResponseEntity sendEmail(EmailDto email){
        try{
            var message = new SimpleMailMessage();
            message.setFrom("noreplay@email.com");
            message.setTo(email.to());
            message.setSubject(email.subject());
            message.setText(email.body());
            mailSender.send(message);
            return ResponseEntity.ok("Produto cadastrado na aplicacao conforme solicitacao");
        }catch (Exception e){
            return ResponseEntity.ok("Email nao enviado");
        }
    }
}
