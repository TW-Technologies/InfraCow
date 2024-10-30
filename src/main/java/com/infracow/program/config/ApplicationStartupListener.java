package com.infracow.program.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class ApplicationStartupListener {
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady() {
		System.out.println("Aplicação Iniciada  na porta: localhost:8080/user/");
	}

}
