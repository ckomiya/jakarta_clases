package pe.jakarta.lp1.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
	
	@Id
    @Column(name = "CLIENTE_ID")
    private Integer clienteId;

    @Column(name = "NOMBRE")
    @NotNull
    @Size(min = 2, max = 20)
    private String nombre;

    @Column(name = "APELLIDO")
    @NotNull
    @Size(min = 2, max = 20)
    private String apellido;

    private String email;
    
    @OneToOne(mappedBy = "cliente")
    private Login login;
    
    @OneToMany(mappedBy = "cliente")
    private Set<Pedido> pedidos;
    

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
    
	
    

}
