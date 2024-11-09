package pe.jakarta.lp1.cdi.websocket;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class FacesWebSocketMessageSender implements Serializable {

	private static final Logger LOG = Logger.getLogger(FacesWebSocketMessageSender.class.getName());

	@Inject
	@Push(channel = "websocketdemo")
	private PushContext pushContext;

	public void send(String message) {
		LOG.log(Level.INFO, String.format("" + "Sending message: %s", message));
		pushContext.send(message);
	}
}