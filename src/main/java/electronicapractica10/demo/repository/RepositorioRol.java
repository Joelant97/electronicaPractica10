package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {

}
