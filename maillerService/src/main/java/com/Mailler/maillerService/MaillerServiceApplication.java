package com.Mailler.maillerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MaillerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaillerServiceApplication.class, args);
	}

}
