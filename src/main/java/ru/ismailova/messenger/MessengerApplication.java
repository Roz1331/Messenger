package ru.ismailova.messenger;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class MessengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);
	}

	@Bean
	ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://127.0.0.1:6616");
	}
}
