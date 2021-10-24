package Reto3G36.Reto3.repository;


import Reto3G36.Reto3.interfaz.InterfaceBoat;
import Reto3G36.Reto3.model.Boat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioBoat {
    @Autowired
    private InterfaceBoat crud;

    public List<Boat> getAll(){
        return (List<Boat>) crud.findAll();
    }

    public Optional<Boat> getBoat (int id){
        return crud.findById(id);

    }

    public Boat save (Boat boat){
        return crud.save(boat);
    }

    public void delete (Boat boat){
        crud.delete(boat);
    }

}
