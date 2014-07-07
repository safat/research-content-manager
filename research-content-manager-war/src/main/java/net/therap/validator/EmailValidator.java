package net.therap.validator;

import net.therap.service.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@ManagedBean
@RequestScoped
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    @EJB
    private UserService userService;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {

        String email = value.toString();
        FacesMessage msg;

        if (!isvalidEmail(email)) {
            msg = new FacesMessage("E-mail validation failed.","Invalid E-mail format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        } else if (isEmailAlreadyRegistered(email)) {
            msg = new FacesMessage("E-mail validation failed.","Email already registered.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }


    }

    private boolean isEmailAlreadyRegistered(String email) {
      return userService.isEmailAlreadyRegistered(email);
    }

    private boolean isvalidEmail(String email){
        Pattern pattern =  Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email.toString());

        return matcher.matches();
    }
}