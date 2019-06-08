package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNombre(String nombre);
    List<Cliente> findAllByActivo(Boolean aBoolean);
    Cliente findById(long id);
}