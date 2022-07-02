package ru.ismailova.messenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

public class ConsumerService {

    private Connection connection;
    private Session session;
    private Destination destination;
    private MessageConsumer messageConsumer;
    private List<String> messages;

    @Autowired
    public ConsumerService(ConnectionFactory connectionFactory) {
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("MESSENGER");
            messageConsumer = session.createConsumer(destination);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllMessages() {
        List<String> allMessages = new ArrayList<>(messages);
        return allMessages;
    }

    public void addMessage(Message message) {
        messages.add(message.toString());
    }

    // documentation: https://activemq.apache.org/hello-world

}
