package pe.jakarta.lp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIRECCION")
public class Direccion {

	@Id
	@Column(name = "DIRECCION_ID")
	private int direccionId;

	@Column(name = "LINEA_DIRECCION_1")
	private String lineaDireccion1;

	@Column(name = "LINEA_DIRECCION_2")
	private String lineaDireccion2;

	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "CODIGO_POSTAL", length = 5)
	private String codigoPostal;

	@ManyToOne
	@JoinColumn(name = "DEPARTAMENTO_ID", referencedColumnName = "DEPARTAMENTO_ID")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID")
	private Cliente cliente;
	
    @ManyToOne
    @JoinColumn(name = "TIPO_DIRECCION_ID", referencedColumnName = "TIPO_DIRECCION_ID")
    private TipoDireccion tipoDireccion;

	public Direccion() {
		
	}

	public Direccion(int direccionId, String lineaDireccion1, String lineaDireccion2, String ciudad,
			String codigoPostal, Departamento departamento, Cliente cliente, TipoDireccion tipoDireccion) {
		super();
		this.direccionId = direccionId;
		this.lineaDireccion1 = lineaDireccion1;
		this.lineaDireccion2 = lineaDireccion2;
		this.ciudad = ciudad;
		this.codigoPostal = codigoPostal;
		this.departamento = departamento;
		this.cliente = cliente;
		this.tipoDireccion = tipoDireccion;
	}

	public int getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(int direccionId) {
		this.direccionId = direccionId;
	}

	public String getLineaDireccion1() {
		return lineaDireccion1;
	}

	public void setLineaDireccion1(String lineaDireccion1) {
		this.lineaDireccion1 = lineaDireccion1;
	}

	public String getLineaDireccion2() {
		return lineaDireccion2;
	}

	public void setLineaDireccion2(String lineaDireccion2) {
		this.lineaDireccion2 = lineaDireccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	
}
