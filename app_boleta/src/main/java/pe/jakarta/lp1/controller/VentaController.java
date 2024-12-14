package pe.jakarta.lp1.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import pe.jakarta.lp1.dao.ProductoDao;
import pe.jakarta.lp1.dao.TipoProductoDao;
import pe.jakarta.lp1.dao.VentaDao;
import pe.jakarta.lp1.entity.DetalleVenta;
import pe.jakarta.lp1.entity.Producto;
import pe.jakarta.lp1.entity.TipoProducto;
import pe.jakarta.lp1.entity.Venta;

@Named
@SessionScoped
public class VentaController implements Serializable{

	@EJB
	TipoProductoDao tipoProductoDao;
	
	@EJB
	ProductoDao productoDao;
	
	@EJB
	VentaDao ventaDao;
	
	List<TipoProducto> tiposDeProducto;
	
	List<Producto> productos;
	
	TipoProducto tipoDeProductoSeleccionado = new TipoProducto();
	
	
	DetalleVenta tempDetalle = new DetalleVenta();
	
	BigDecimal total;
	
	
	List<DetalleVenta> tempDetalleVentaList = new ArrayList<DetalleVenta>();
	
	Venta venta = new Venta();
	
	@PostConstruct
    public void init() {
        tiposDeProducto = tipoProductoDao.obtenerTiposDeProducto(); // Método para obtener tipos de producto
    }
	
	public String agregarItem() {
		Integer productoIdSeleccionado = tempDetalle.getProducto().getId();
		Producto producto = obtenerProductoDeDetalleVentaList(productoIdSeleccionado);
		tempDetalle.setProducto(producto);
		tempDetalle.setPrecioUnitario(producto.getPrecio());
		tempDetalle.setSubtotal(new BigDecimal(tempDetalle.getCantidad()*producto.getPrecio().doubleValue()));
		
		tempDetalleVentaList.add(tempDetalle);
		
		tempDetalle = new DetalleVenta();
		tipoDeProductoSeleccionado = new TipoProducto();
		
		actualizaTotal();
		return null;
	
	}
	
	private void actualizaTotal() {
		venta.setTotal(BigDecimal.ZERO);
		
		for (DetalleVenta detalle : tempDetalleVentaList) {
			venta.setTotal(venta.getTotal().add(detalle.getSubtotal()));
		}
		
	}

	private Producto obtenerProductoDeDetalleVentaList(Integer productoIdSeleccionado) {
		for (Producto producto : productos) {
			if(productoIdSeleccionado.equals(producto.getId())) {
				return producto;
			}
		}
		return null;
	}

	public void cargarProductosPorTipo() {
        if (tipoDeProductoSeleccionado != null) {
            // Cargar productos según el tipo seleccionado
            productos = productoDao.obtenerProductosPorTipo(tipoDeProductoSeleccionado);
        } else {
            productos = new ArrayList<>();  // Si no hay tipo seleccionado, no se cargan productos
        }
    }
	
	
	public String registrarVenta() {
		
		for (DetalleVenta detalle : tempDetalleVentaList) {
		    detalle.setVenta(venta);
		}
		
		
		venta.setDetalles(tempDetalleVentaList);
		venta.setFecha(LocalDate.now());
		ventaDao.registrarVenta(venta);
		
		  FacesContext.getCurrentInstance().addMessage(null, 
			        new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta registrada satisfactoriamente", ""));
		
		return null;
	}
	
	


	public List<TipoProducto> getTiposDeProducto() {
		return tiposDeProducto;
	}

	public void setTiposDeProducto(List<TipoProducto> tiposDeProducto) {
		this.tiposDeProducto = tiposDeProducto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public TipoProducto getTipoDeProductoSeleccionado() {
		return tipoDeProductoSeleccionado;
	}

	public void setTipoDeProductoSeleccionado(TipoProducto tipoDeProductoSeleccionado) {
		this.tipoDeProductoSeleccionado = tipoDeProductoSeleccionado;
	}

	

	public List<DetalleVenta> getTempDetalleVentaList() {
		return tempDetalleVentaList;
	}


	public void setTempDetalleVentaList(List<DetalleVenta> tempDetalleVentaList) {
		this.tempDetalleVentaList = tempDetalleVentaList;
	}


	public Venta getVenta() {
		return venta;
	}


	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public DetalleVenta getTempDetalle() {
		return tempDetalle;
	}

	public void setTempDetalle(DetalleVenta tempDetalle) {
		this.tempDetalle = tempDetalle;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	

	
	
	
}
