package Reto3G36.Reto3.repository;


import Reto3G36.Reto3.interfaz.InterfaceCliente;
import Reto3G36.Reto3.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioCliente {

    @Autowired
    private InterfaceCliente crud1;

    public List<Cliente> getAll(){
        return (List<Cliente>) crud1.findAll();
    }

    public Optional<Cliente> getCliente (int id){
        return crud1.findById(id);

    }

    public Cliente save (Cliente cliente){
      return crud1.save(cliente);
    }

    public void delete (Cliente cliente){
      crud1.delete(cliente);
    }
}
