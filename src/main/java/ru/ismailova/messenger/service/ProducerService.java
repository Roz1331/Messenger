package ru.ismailova.messenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class ProducerService {

    private final Connection connection;
    private Session session;
    private Destination destination;
    private MessageProducer messageProducer;

    @Autowired
    public ProducerService(ConnectionFactory connectionFactory) {

        try {
            this.connection = connectionFactory.createConnection();
            connection.start();
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
            messageProducer.send(textMessage);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    // documentation: https://activemq.apache.org/hello-world
}
