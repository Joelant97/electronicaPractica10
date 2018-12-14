package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository  //
public interface RepositorioCliente extends JpaRepository<Cliente, Long>{
}


