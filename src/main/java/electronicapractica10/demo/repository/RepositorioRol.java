package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {


    Rol findByRole(String rol);



}
