package pe.jakarta.lp1.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import jakarta.faces.component.html.HtmlInputText;

@FacesValidator(value = "emailValidator")
public class EmailAddressValidator  implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent uiComponent, Object value) throws ValidatorException {
		EmailValidator emailValidator = EmailValidator.getInstance();
	    HtmlInputText htmlInputText = (HtmlInputText) uiComponent;

	    String emailAddress = (String) value;

	    if (!StringUtils.isEmpty(emailAddress)) {
	      if (!emailValidator.isValid(emailAddress)) {
	        FacesMessage facesMessage = new FacesMessage(htmlInputText.
	                getLabel()
	                + ": formato de email inválido");
	        throw new ValidatorException(facesMessage);
	      }
	    }
	  }
	}