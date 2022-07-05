package ru.ismailova.messenger;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Topic;

@SpringBootApplication
@EnableJms
public class MessengerApplication {

	@Bean
	ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
	}

	@Bean
	Topic destination() {
		return new ActiveMQTopic("MESSENGER");
	}

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);
	}


}
