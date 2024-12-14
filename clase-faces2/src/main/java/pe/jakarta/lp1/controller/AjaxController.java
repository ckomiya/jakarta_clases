package pe.jakarta.lp1.controller;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class AjaxController implements Serializable {

	private String texto;
	private int primerOperador;
	private int segundoOperador;
	private String selectOperador;

	private int total;

	public void prueba(AjaxBehaviorEvent actionEvent) {
		System.out.println("pruebaaa");
	}
	public void calcularTotal(ActionEvent actionEvent) {
		total = primerOperador + segundoOperador;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getPrimerOperador() {
		return primerOperador;
	}

	public void setPrimerOperador(int primerOperador) {
		this.primerOperador = primerOperador;
	}

	public int getSegundoOperador() {
		return segundoOperador;
	}

	public void setSegundoOperador(int segundoOperador) {
		this.segundoOperador = segundoOperador;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public String getSelectOperador() {
		return selectOperador;
	}
	public void setSelectOperador(String selectOperador) {
		this.selectOperador = selectOperador;
	}
	
	

}
