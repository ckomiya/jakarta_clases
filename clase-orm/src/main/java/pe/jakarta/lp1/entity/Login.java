package pe.jakarta.lp1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "INFORMACION_LOGIN")
public class Login {

	@Id
    @Column(name = "INFORMACION_LOGIN_ID")
    private Integer loginId;
	
	@Column(name = "NOMBRE_LOGIN")
    private String nombre;

    @Column(name = "CONTRASENA")
    private String contrasena;


    @OneToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
