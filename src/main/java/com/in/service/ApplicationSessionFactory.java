package com.in.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationSessionFactory {

	@Bean
	public SessionFactory sessionFactoryGenerator() {
		return new Configuration().configure().buildSessionFactory();
	}
}
