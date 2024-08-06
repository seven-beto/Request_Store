package com.example.TrainingJunior.controller;


import com.example.TrainingJunior.dtos.EmailDto;
import com.example.TrainingJunior.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Email")
public class EmailController {

    public final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity email(@RequestBody EmailDto email){
        var sendEmail = emailService.sendEmail(email);
        return new ResponseEntity<>(sendEmail, HttpStatus.CREATED);
    }

}
