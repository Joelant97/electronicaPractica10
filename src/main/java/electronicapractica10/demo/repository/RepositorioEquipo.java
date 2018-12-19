package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioEquipo extends JpaRepository <Equipo, Long> {


}
