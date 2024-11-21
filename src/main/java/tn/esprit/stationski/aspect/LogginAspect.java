package tn.esprit.stationski.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogginAspect {

    @Before("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryBefore(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method Before " + name + " : ");
    }

    @After("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method After " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryAfterTH(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method AfterThrowing " + name + " : ");
    }

    @AfterReturning("execution(* tn.esprit.stationski.serviceImp.*.*(..))")
    public void logMethodEntryAfterRT(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method AfterReturning " + name + " : ");
    }




}
