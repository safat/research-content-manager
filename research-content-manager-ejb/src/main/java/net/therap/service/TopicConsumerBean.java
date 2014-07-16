package net.therap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven (mappedName = "jms/researchContentManagerTopic", activationConfig = {
        @ActivationConfigProperty (
                propertyName = "subscriptionDurability",
                propertyValue = "Durable"),
        @ActivationConfigProperty (propertyName = "clientId", propertyValue = "MyID2"),
        @ActivationConfigProperty (propertyName = "subscriptionName", propertyValue = "MySub2")
})
public class TopicConsumerBean implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(TopicConsumerBean.class);

    public TopicConsumerBean() {
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            log.info("Consumed Message From 1 : " + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}