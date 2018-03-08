package com.sinosoft.activemq.consumer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

//    @Resource(name = "jmsTemplate")
	@Autowired
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        if (tm != null) {
            try {
                System.out.println("Get Message: " + tm.getText() + " from Destination " + destination.toString());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return tm;
    }

}
