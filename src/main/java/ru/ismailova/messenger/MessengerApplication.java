package ru.ismailova.messenger;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

@SpringBootApplication
public class MessengerApplication {

	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://127.0.0.1:8181");
	}

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);
	}

}
