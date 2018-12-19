package electronicapractica10.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Categoria categoria;
    @OneToMany(mappedBy = "categoria", orphanRemoval = true)
    private Collection<Categoria> subCategoria;

    @ElementCollection
    private List<Long> diasAlquilados;

    public Categoria (){

    }

    public Categoria(String nombre, Categoria categoria, Collection<Categoria> subCategoria, List<Long> diasAlquilados) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.diasAlquilados = diasAlquilados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Collection<Categoria> getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Collection<Categoria> subCategoria) {
        this.subCategoria = subCategoria;
    }

    public List<Long> getDiasAlquilados() {
        return diasAlquilados;
    }

    public void setDiasAlquilados(List<Long> diasAlquilados) {
        this.diasAlquilados = diasAlquilados;
    }
}
