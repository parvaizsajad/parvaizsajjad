package com.email.controllers;

import com.email.Service.EmailService;
import com.email.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class ControllerHandler{

    @Autowired
    private EmailService emailService;
    @RequestMapping("/welcome")
    public String Home(){
        System.out.println("this is the home controller");
        return "home.html";
    }
    @PostMapping("/send")
    public ResponseEntity<?> SendMail(@RequestBody EmailRequest request) throws MessagingException {
        System.out.println(request);

        emailService.sendmail(request.getFrom(),request.getSubject(),request.getMessage(),request.getTo());
return ResponseEntity.ok("done");
    }
}
