package com.stackroute.activitystream.circle;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
@EntityScan(basePackages={"com.stackroute.activitystream.circle"})

@SpringBootApplication
public class CircleServiceApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(CircleServiceApplication.class, args);
	}
	
	@Bean
	public SessionFactory getSessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
	{
		System.out.println("in getSession");
		SessionFactory sessionFactory=hibernateEntityManagerFactory.getSessionFactory();
		System.out.println("======"+sessionFactory);
		
return sessionFactory;
	}
}
