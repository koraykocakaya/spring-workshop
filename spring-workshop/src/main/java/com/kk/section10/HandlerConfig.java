package com.kk.section10;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

@Configuration
@ComponentScan("com.kk.section10")
public class HandlerConfig { 
	
	@Bean
	public ApplicationListener<ContextClosedEvent> getApplicationListener(){
		return (event) -> System.out.println("Closed event: " + event);
	}
	
	@EventListener
    public void handleContextClosed(ContextClosedEvent cse) {
        System.out.println("Handling context closed event.");
    }
	
}
