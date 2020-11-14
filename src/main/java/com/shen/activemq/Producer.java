package com.shen.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {

    private static final String QUEUE_NAME="activemq_queue";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory factory= new ActiveMQConnectionFactory("tcp://172.20.10.7:61616");

        Connection connection=factory.createConnection();

        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue=session.createQueue(QUEUE_NAME);
        MessageProducer producer=session.createProducer(queue);
        TextMessage textMessage=session.createTextMessage("Hello world!");
//        TextMessage textMessage=session.createObjectMessage();
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();

    }

}
