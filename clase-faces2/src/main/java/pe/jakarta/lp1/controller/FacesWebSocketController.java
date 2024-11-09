package pe.jakarta.lp1.controller;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import pe.jakarta.lp1.cdi.websocket.FacesWebSocketMessageSender;

@Named
@SessionScoped
public class FacesWebSocketController implements Serializable {

	@Inject
	private FacesWebSocketMessageSender facesWebSocketMessageSender;

	private String userName;
	private String message;

	public void sendMessage() {
		facesWebSocketMessageSender.send(String.format("%s: %s", userName, message));
		message = "";
	}

	public String navigateToChatPage() {
		return "chat";
	}

	public FacesWebSocketMessageSender getJsfWebSocketMessageSender() {
		return facesWebSocketMessageSender;
	}

	public void setJsfWebSocketMessageSender(FacesWebSocketMessageSender jsfWebSocketMessageSender) {
		this.facesWebSocketMessageSender = jsfWebSocketMessageSender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
