package Reto3G36.Reto3.repository;

import Reto3G36.Reto3.interfaz.InterfaceReservaciones;
import Reto3G36.Reto3.model.Cliente;
import Reto3G36.Reto3.model.Reservaciones;
import Reto3G36.Reto3.reportes.ContadorClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
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
    public List<Reservaciones> ReservacionStatusRepositorio (String status){
        return crud3.findAllByStatus(status);
    }

    public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){
        return crud3.findAllByStartDateAfterAndStartDateBefore(a, b);

    }
    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud3.countTotalReservationsByCliente();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }

}
