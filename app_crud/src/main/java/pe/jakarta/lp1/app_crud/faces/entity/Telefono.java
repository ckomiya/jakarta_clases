package pe.jakarta.lp1.app_crud.faces.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TELEFONO")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TELEFONO_ID")
    private int telefonoId;

    @ManyToOne
    @JoinColumn(name = "TIPO_TELEFONO_ID", referencedColumnName = "TIPO_TELEFONO_ID", nullable = false)
    private TipoTelefono tipoTelefono;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID", nullable = false)
    private Cliente cliente;

    @Column(name = "NUMERO_TELEFONO", length = 12, nullable = false)
    private String numeroTelefono;

    // Getters y setters
    public int getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(int telefonoId) {
        this.telefonoId = telefonoId;
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
