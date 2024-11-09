package pe.jakarta.lp1.validator;

import org.apache.commons.lang3.StringUtils;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

@Named
@RequestScoped
public class AlfaValidator {

	public void validarAlfabetico(FacesContext facesContext, UIComponent uiComponent, Object value)
			throws ValidatorException {
		if (!StringUtils.isAlphaSpace((String) value)) {
			HtmlInputText htmlInputText = (HtmlInputText) uiComponent;
			FacesMessage facesMessage = new FacesMessage(
					htmlInputText.getLabel() + ": solo está permitido caracteres alfabéticos");
			throw new ValidatorException(facesMessage);
		}
	}
}
