package pe.jakarta.lp1.controller;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import pe.jakarta.lp1.dao.ProductoDao;
import pe.jakarta.lp1.dao.TipoProductoDao;
import pe.jakarta.lp1.entity.Producto;
import pe.jakarta.lp1.entity.TipoProducto;

@Named
@ViewScoped
public class ProductoController implements Serializable{
	
	@EJB
	ProductoDao productoDao;
	
	@EJB
	TipoProductoDao tipoProductoDao;
	
	Producto producto = new Producto();
	
	private List<Producto> productos;
	
	private List<TipoProducto> tiposDeProducto;
	
	public String guardarProducto() {
	    productoDao.guardar(producto);
	    // Limpia el objeto producto
	    producto = new Producto();
	    // Mostrar mensaje de éxito
	    FacesContext.getCurrentInstance().addMessage(null, 
	        new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto guardado satisfactoriamente", ""));
	    return null;  // Mantener en la misma página
	}
	
	
	

	public List<Producto> getProductos() {
		productos = productoDao.obtenerProductos();
		return productos;
	}
	
	public List<TipoProducto> getTiposDeProducto() {
		tiposDeProducto = tipoProductoDao.obtenerTiposDeProducto();
		return tiposDeProducto;
	}
	
	

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	

	public void setTiposDeProducto(List<TipoProducto> tiposDeProducto) {
		this.tiposDeProducto = tiposDeProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	

}
