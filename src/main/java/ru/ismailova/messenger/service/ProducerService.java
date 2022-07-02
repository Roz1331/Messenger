package ru.ismailova.messenger.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;

public class ProducerService {

    Connection connection;
    Session session;
    Destination destination;
    MessageProducer messageProducer;

    @Autowired
    public ProducerService() {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
        try {
            this.connection = connectionFactory.createConnection();
            this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            this.destination = session.createQueue("MESSENGER");
            this.messageProducer = session.createProducer(destination);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

    public void SendMessage(String message) {
        try {
            TextMessage textMessage = session.createTextMessage(message);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }


    // documentation: https://activemq.apache.org/hello-world
}
