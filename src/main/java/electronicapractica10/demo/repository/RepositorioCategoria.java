package electronicapractica10.demo.repository;


import electronicapractica10.demo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long> {
    Categoria findByIdAnd(Long id);

}