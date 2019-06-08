package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Factura findById(long id);

}
