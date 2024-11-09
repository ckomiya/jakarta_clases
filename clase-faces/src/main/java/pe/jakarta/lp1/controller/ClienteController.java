package pe.jakarta.lp1.controller;

import java.io.IOException;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class ClienteController {

	public String guardarCliente() throws IOException {
		String paginaDestino = "confirmacion";
		boolean error = false;
		if(error) {
			paginaDestino = "index";
		}

		return paginaDestino;
	}

}
