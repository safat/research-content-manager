package net.therap.service;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 * Created by shakhawat.hossain on 7/14/14.
 */

@Stateless
public class EmailConfirmationQueueProducer {

    @Resource (mappedName = "jms/researchContentManagerCF")
    private ConnectionFactory connectionFactory;

    @Resource (mappedName = "jms/researchContentManagerQueue")
    private Queue queue;

    public void queueEmailConfirmation(String recipientEmail) {
        MessageProducer messageProducer = null;
        Session session = null;
        Connection connection = null;

        TextMessage textMessage;
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(queue);

            textMessage = session.createTextMessage();
            textMessage.setText(recipientEmail);


            messageProducer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                messageProducer.close();
                session.close();
                connection.close();
            } catch (JMSException | NullPointerException exception) {
                exception.printStackTrace();
            }

        }

    }
}
