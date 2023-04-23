package ru.mirea.pract14;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    @Before("allServiceMethods()")
    public void logTime(JoinPoint joinPoint) {
        log.info("Class: {}, Method: {}, Time: {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), sdf.format(timestamp.getTime()));
    }
    @Pointcut("within(ru.mirea.pract14.service.*)")
    public void allServiceMethods() {}
}
