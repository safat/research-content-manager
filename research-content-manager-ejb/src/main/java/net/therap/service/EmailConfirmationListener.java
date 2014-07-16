package net.therap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by shakhawat.hossain on 7/14/14.
 */
@MessageDriven (mappedName = "jms/researchContentManagerQueue",
        activationConfig = {
                @ActivationConfigProperty (
                        propertyName = "acknowledgeMode",
                        propertyValue = "Auto-acknowledge"),
                @ActivationConfigProperty (
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue")
        })
public class EmailConfirmationListener implements MessageListener {
    private Logger log = LoggerFactory.getLogger(EmailConfirmationListener.class);

    @EJB
    private EmailService emailService;

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String recipientEmail = textMessage.getText();
            emailService.sendConfirmationEmail(recipientEmail);

            log.info("email popped from queue and confirmation email and sent to {}", recipientEmail);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
