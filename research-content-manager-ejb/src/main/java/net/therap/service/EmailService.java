package net.therap.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by shakhawat.hossain on 7/15/14.
 */

@Stateless
public class EmailService {
    @Resource (name = "mailSession")
    private Session mailSession;

    public void sendConfirmationEmail(String recipientEmail){
        Message msg = new MimeMessage(mailSession);
        try {
            msg.setSubject("Welcome To Research Content Manager");
            msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientEmail));

            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Its very nice to have you with us." +
                    "Please confirm your request through the following link");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);

            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}
