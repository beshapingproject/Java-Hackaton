package it.be.codingRace.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SessionAspect {

	private static final Logger logger = LogManager.getLogger(SessionAspect.class);
	
	@Before("execution(* it.be.codingRace.controller.*.*(..))")
	public void sessionBefore(JoinPoint joinPoint) {
		logger.debug("{} - Session managing", joinPoint);
	}
}
