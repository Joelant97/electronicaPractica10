package electronicapractica10.demo.repository;


import electronicapractica10.demo.model.Cliente;
import electronicapractica10.demo.model.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositorioRenta extends JpaRepository<Renta, Long> {
    List<Renta> findAllByClienteOrderByFechaInicioRenta(Cliente cliente);
    List<Renta> findByCliente_IdOrderByFechaInicioRenta(long id);


    @Query(value = "SELECT CLI.NOMBRE, EQ.NOMBRE_EQUIPO, ABS(DATEDIFF('DAY',  ALQ.FECHA_INICIO_ALQUILER, ALQ.FECHA_FIN_ALQUILER )) AS DIAS " +
            "FROM  ALQ INNER JOIN CLIENTE CLI ON CLI.ID = ALQ.CLIENTE_ID INNER JOIN EQUIPO EQ ON EQ.ID = ALQ.EQUIPO_ID " +
            "WHERE ALQ.ESTADO = 'Pendiente' ORDER BY ALQ.FECHA_INICIO_ALQUILER", nativeQuery = true)
    List<Object[]> equiposRentaNoDevueltos();

}


