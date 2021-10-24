package Reto3G36.Reto3.repository;

import Reto3G36.Reto3.interfaz.InterfaceReservaciones;
import Reto3G36.Reto3.model.Reservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioReservaciones {

    @Autowired
    private InterfaceReservaciones crud3;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud3.findAll();
    }

    public Optional<Reservaciones> getReservation (int id){
        return crud3.findById(id);

    }

    public Reservaciones save (Reservaciones reservation){
      return crud3.save(reservation);
    }

    public void delete (Reservaciones reservation){
      crud3.delete(reservation);
    }
}
