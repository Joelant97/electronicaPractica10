package electronicapractica10.demo.repository;

import electronicapractica10.demo.model.Rol;
import electronicapractica10.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findFirstByRolSetEquals(Set<Rol> rol);
    Usuario findByUsuario(String usuario);
    Usuario findByNombreAndPassword(String nombre, String password);
    Usuario findById(long id);


    Usuario findByNombre(String username);

    List<Usuario> findAllByActivo(Boolean estado);
}
