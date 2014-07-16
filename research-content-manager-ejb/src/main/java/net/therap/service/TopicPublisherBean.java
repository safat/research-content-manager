package net.therap.service;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
@Local
public class TopicPublisherBean {

    @Resource (mappedName = "jms/researchContentManagerCF")
    private ConnectionFactory connectionFactory;

    private TopicConnection topicConnection;

    @Resource(mappedName = "jms/researchContentManagerTopic")
    private Topic topic;

    @Inject
    private TopicSession session;

    public void publishNews(String messageToPublish) {
        try {
            topicConnection = (TopicConnection) connectionFactory.createConnection();
            session = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            TextMessage message = session.createTextMessage();
            message.setText(messageToPublish);

            TopicPublisher topicPublisher = session.createPublisher(topic);
            topicPublisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            topicPublisher.publish(message);

        } catch (JMSException e) {
            e.printStackTrace();
        }
        finally {
            try {
                topicConnection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
