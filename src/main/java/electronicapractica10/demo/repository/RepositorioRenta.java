package electronicapractica10.demo.repository;


import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioRenta extends JpaRepository<Renta, Long> {
    List<Renta> findAllByClienteOrderByFechaInicioRenta(Cliente cliente);



    //@Query("SELECT renta FROM Renta renta ORDER BY renta.fecha")
    //List<Renta> rentasOrdenadas();

}


