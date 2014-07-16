package net.therap.action;

import net.therap.service.TopicPublisherBean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by shakhawat.hossain on 7/15/14.
 */
@Named(value = "topicPublish")
@RequestScoped
public class TopicPublishAction {

    @EJB
    private TopicPublisherBean publisherBean;
    private String message;

    public void publishNews(){
        publisherBean.publishNews(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
