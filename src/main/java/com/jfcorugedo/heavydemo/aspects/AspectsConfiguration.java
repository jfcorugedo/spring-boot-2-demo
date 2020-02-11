package com.jfcorugedo.heavydemo.aspects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectsConfiguration {

    @Bean
    public LoggingAspect logginAspect() {
        System.out.println("Initilizing LoggingAspect");
        return new LoggingAspect();
    }
}
