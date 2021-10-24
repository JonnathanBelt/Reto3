package Reto3G36.Reto3.repository;

import Reto3G36.Reto3.interfaz.InterfaceMensaje;
import Reto3G36.Reto3.model.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioMensaje {
    @Autowired
    private InterfaceMensaje crud2;

    public List<Mensaje> getAll(){
        return (List<Mensaje>) crud2.findAll();
    }

    public Optional<Mensaje> getMessage (int id){
        return crud2.findById(id);

    }

    public Mensaje save (Mensaje message){
      return crud2.save(message);
    }

    public void delete (Mensaje message){
      crud2.delete(message);
    }
}
