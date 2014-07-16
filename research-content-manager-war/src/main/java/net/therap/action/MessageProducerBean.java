package net.therap.action;


import net.therap.service.EmailConfirmationQueueProducer;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by shakhawat.hossain on 7/14/14.
 */

@Named ("messageProducerBean")
@RequestScoped
public class MessageProducerBean {

    private String email;

    @EJB
    private EmailConfirmationQueueProducer emailConfirmationQueue;


    public void send() {
        emailConfirmationQueue.queueEmailConfirmation(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
