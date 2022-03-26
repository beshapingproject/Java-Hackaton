package it.be.codingRace.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {
	
	private static final Logger logger = LogManager.getLogger(LoggerAspect.class);
	
	@Before("execution(* it.be.codingRace.*.*(..))")
	public void logsBefore(JoinPoint joinPoint) {
		logger.debug("{} - START", joinPoint);
	}
	
	@After("execution(* it.be.codingRace.*.*(..))")
	public void logsAfter(JoinPoint joinPoint) {
		logger.debug("{} - END", joinPoint);
	}
	
	@AfterReturning(value = "execution(* it.be.codingRace.*.*(..))", returning = "result")
	public void logsAfterReturning(JoinPoint joinPoint, Object result) {
		logger.debug("{} returns {}", joinPoint, result);
	}
	
	@AfterThrowing(value = "execution(* it.be.codingRace.*.*(..))", throwing = "ex")
	public void logsAfterThrowing(Exception ex) throws Throwable {
		logger.error("Logging exception: {}", ex);
	}
}
