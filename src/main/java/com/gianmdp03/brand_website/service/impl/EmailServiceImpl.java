package com.gianmdp03.brand_website.service.impl;

import com.gianmdp03.brand_website.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String email;

    @Override
    public void sendEmail(String subject, String to, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(email);
        message.setSubject(subject);
        message.setTo(to);
        message.setText(body);

        javaMailSender.send(message);
    }
}
