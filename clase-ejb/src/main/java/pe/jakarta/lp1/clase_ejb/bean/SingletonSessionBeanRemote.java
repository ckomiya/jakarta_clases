package pe.jakarta.lp1.clase_ejb.bean;

import java.util.List;

import jakarta.ejb.Remote;
import pe.jakarta.lp1.clase_ejb.entity.Departamento;

@Remote
public interface SingletonSessionBeanRemote {

  List<Departamento> obtenerDepartamentos();
}
