package com.siecola.aws.sqs.subscriber.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class NotificationComponent {

    @Autowired
    protected JmsTemplate defaultJmsTemplate;

    public void sendMessage() {
        defaultJmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                final TextMessage msg = session.createTextMessage("Teste message to be sent");

                return msg;
            }
        });
    }
}