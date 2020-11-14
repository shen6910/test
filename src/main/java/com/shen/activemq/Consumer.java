package com.shen.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Consumer {

    private static final String QUEUE_NAME = "activemq_queue";

    public static void main(String[] args) throws JMSException, IOException {

        ConnectionFactory factory=new ActiveMQConnectionFactory("tcp://172.20.10.7:61616");
        Connection connection=factory.createConnection();
        connection.start();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue=session.createQueue(QUEUE_NAME);

        MessageConsumer consumer=session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
               TextMessage textMessage = (TextMessage) message;
               try{
                   System.out.println(textMessage.getText());
               }catch (JMSException e){
                   e.printStackTrace();
               }
            }
        });
        System.in.read();
        consumer.close();
        connection.close();
    }



}
