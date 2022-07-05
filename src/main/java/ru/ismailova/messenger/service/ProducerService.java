package ru.ismailova.messenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class ProducerService {

    private final Connection connection;
    private Session session;
    private MessageProducer messageProducer;

    @Autowired
    public ProducerService(ConnectionFactory connectionFactory, Topic topic) {

        try {
            this.connection = connectionFactory.createConnection();
            connection.start();
            this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            this.messageProducer = session.createProducer(topic);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendMessage(String message) {
        try {
            TextMessage textMessage = session.createTextMessage(message);
            messageProducer.send(textMessage);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    // documentation: https://activemq.apache.org/hello-world
}
