package ru.ismailova.messenger;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class MessengerApplication {

	@Bean
	ActiveMQConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("vm://localhost");
	}

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);
	}

}
