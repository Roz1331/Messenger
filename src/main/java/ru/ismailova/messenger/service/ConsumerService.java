package ru.ismailova.messenger.service;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class ConsumerService implements MessageListener{

    private Connection connection;
    private Session session;
    private MessageConsumer messageConsumer;
    private List<String> messages = new ArrayList<>();

    @Autowired
    public ConsumerService(ConnectionFactory connectionFactory, Topic topic) {
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(topic);

            messageConsumer.setMessageListener(this);

        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAllMessages() {
        List<String> allMessages = new ArrayList<>(messages);
        messages.clear();
        return allMessages;
    }

//    public void addMessage(Message message) {
//
//    }

    @Override
    public void onMessage(Message message) {
        try {
            ActiveMQTextMessage textMessage = (ActiveMQTextMessage) message;
            String json = textMessage.getText();
            messages.add(json);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }

    }

    // https://activemq.apache.org/hello-world

}
