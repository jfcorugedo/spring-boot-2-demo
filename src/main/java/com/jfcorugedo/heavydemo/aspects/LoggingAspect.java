package com.jfcorugedo.heavydemo.aspects;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.jfcorugedo.heavydemo.products..*.*(..))")
    public void logProductsExecution(JoinPoint joinPoint) {
        printInfo(joinPoint);
    }

    @Before("execution(* com.jfcorugedo.heavydemo.users..*.*(..))")
    public void logUsersExecution(JoinPoint joinPoint) {
        printInfo(joinPoint);
    }

    @Before("execution(* com.jfcorugedo.heavydemo.discounts..*.*(..))")
    public void logDiscountExecution(JoinPoint joinPoint) {
        printInfo(joinPoint);
    }

    @Before("execution(* com.jfcorugedo.heavydemo.taxes..*.*(..))")
    public void logTaxesExecution(JoinPoint joinPoint) {
        printInfo(joinPoint);
    }

    private void printInfo(JoinPoint joinPoint) {
        System.out.println("\n**************************************\n"
                           + "* Entering: " + joinPoint.toString() +
                           "\n* With args: " + Arrays.toString(joinPoint.getArgs()) +
                           "\n* At: " + joinPoint.getSourceLocation().getWithinType() +
                           "\n**************************************\n");
    }
}
