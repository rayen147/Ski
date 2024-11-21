package tn.esprit.stationski.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Comments;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogiingAspect {

    //.add* : les methodes qui commence par add
    @After("execution(* tn.esprit.stationski.services.*.get*(..))")
    public void logMethodEntry(JoinPoint joinPoint){
        String name= joinPoint.getSignature().getName();
        log.info("Ajout avec succées:" +name);
    }}
