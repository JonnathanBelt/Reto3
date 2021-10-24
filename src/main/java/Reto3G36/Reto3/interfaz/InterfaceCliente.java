package Reto3G36.Reto3.interfaz;

import Reto3G36.Reto3.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {
}
