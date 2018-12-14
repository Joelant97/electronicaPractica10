package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

}
