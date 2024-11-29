package pe.jakarta.lp1.app_crud.faces.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_TELEFONO")
public class TipoTelefono {

    @Id
    @Column(name = "TIPO_TELEFONO_ID")
    private int tipoTelefonoId;

    @Column(name = "CODIGO_TIPO_TELEFONO", length = 1, nullable = false)
    private char codigoTipoTelefono;

    @Column(name = "DESCRIPCION_TIPO_TELEFONO", length = 20, nullable = false)
    private String descripcionTipoTelefono;

    @OneToMany(mappedBy = "tipoTelefono", cascade = CascadeType.ALL)
    private List<Telefono> telefonos;

    // Getters y setters
    public int getTipoTelefonoId() {
        return tipoTelefonoId;
    }

    public void setTipoTelefonoId(int tipoTelefonoId) {
        this.tipoTelefonoId = tipoTelefonoId;
    }

    public char getCodigoTipoTelefono() {
        return codigoTipoTelefono;
    }

    public void setCodigoTipoTelefono(char codigoTipoTelefono) {
        this.codigoTipoTelefono = codigoTipoTelefono;
    }

    public String getDescripcionTipoTelefono() {
        return descripcionTipoTelefono;
    }

    public void setDescripcionTipoTelefono(String descripcionTipoTelefono) {
        this.descripcionTipoTelefono = descripcionTipoTelefono;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
}