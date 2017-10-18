package com.siecola.aws.sqs.subscriber.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Service
public class MessageReceiverService {

    private Logger log = Logger.getLogger(MessageReceiverService.class);

    @JmsListener(destination = "test_queue.fifo")
    public void receiveMessageFIFO(TextMessage requestJSON) throws JMSException {
        log.info("Received from FIFO queue");
        log.info("Request JSON message: " + requestJSON.getText());
        log.info("Attribute prop1: " + requestJSON.getStringProperty("prop1"));
        log.info("Group ID: " + requestJSON.getStringProperty("JMSXGroupID"));
    }

    @JmsListener(destination = "test_queue")
    public void receiveMessage(TextMessage requestJSON) throws JMSException {
        log.info("Received from standard queue");
        log.info("Request JSON message: " + requestJSON.getText());
        log.info("Attribute prop1: " + requestJSON.getStringProperty("prop1"));
        log.info("Group ID: " + requestJSON.getStringProperty("JMSXGroupID"));
    }
}