package pe.jakarta.lp1.app_crud.faces.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
public class Cliente implements Serializable {

	
	@Id
    @Column(name = "CLIENTE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "EMAIL")
    private String email;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_AFILIACION") 
    private Date fechaAfiliacion;
    
//    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
//    private Login login = new Login();
    
    @Column(name = "TIPO_CLIENTE")
    private Integer tipoCliente;
    
    @Transient
    private String descTipoCliente;
    
//    @ManyToOne
//    @JoinColumn(name = "TIPO_CLIENTE_ID", referencedColumnName = "TIPO_CLIENTE_ID")
//    private TipoCliente tipoCliente = new TipoCliente();

    
    public Cliente() {}
    
    
    
	public Cliente(int clienteId) {
		this.clienteId = clienteId;
	}



	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

	public String getDescTipoCliente() {
		
		if(tipoCliente.equals(1)) {
			return "Regular";
		}else if(tipoCliente.equals(2)) {
			return "Premium";
		}else if(tipoCliente.equals(3)) {
			return "Corporativo";
		}else {
			return "Vip";
		}
	}



	public void setDescTipoCliente(String descTipoCliente) {
		this.descTipoCliente = descTipoCliente;
	}



	public Integer getTipoCliente() {
		return tipoCliente;
	}



	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	
	



	public Date getFechaAfiliacion() {
		return fechaAfiliacion;
	}



	public void setFechaAfiliacion(Date fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [clienteId=");
		builder.append(clienteId);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
    
    
}
