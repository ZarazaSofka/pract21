package ru.mirea.pract14.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Slf4j
@org.aspectj.lang.annotation.Aspect
@Service
@RequiredArgsConstructor
public class EmailService {

    public static final String EMAIL = "zarazasofka@yandex.ru";
    private final JavaMailSender javaMailSender;
    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @After("createServiceMethods()")
    @Async
    public void sendCreation(JoinPoint joinPoint) {
        sendCreationNote(joinPoint.getArgs()[0]);
    }
    @Pointcut("execution(public void ru.mirea.pract14.service.*Service.create(..))")
    @Async
    public void createServiceMethods() {}

    @Async
    private void sendCreationNote(Object o) throws MailException {
        log.info("Sending email about new {}", o);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(EMAIL);
        mail.setFrom(EMAIL);
        mail.setSubject("Creation of " + o.getClass().getSimpleName());
        mail.setText("At " + sdf.format(timestamp.getTime()) + " was created " + o);
        javaMailSender.send(mail);

        log.info("Email about {} has been sent", o);
    }
}