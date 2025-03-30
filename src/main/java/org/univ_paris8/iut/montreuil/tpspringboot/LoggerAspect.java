package org.univ_paris8.iut.montreuil.tpspringboot;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Before("execution(* org.univ_paris8.iut.montreuil.tpspringboot.services.AnnonceService+.*(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("Méthode exécutée : " + joinPoint.getSignature());
    }
}
