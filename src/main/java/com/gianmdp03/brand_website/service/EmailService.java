package com.gianmdp03.brand_website.service;

public interface EmailService {
    void sendEmail(String subject, String to, String body);
}
