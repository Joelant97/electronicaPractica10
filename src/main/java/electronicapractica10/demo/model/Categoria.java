package electronicapractica10.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private boolean subCategoria;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Categoria categoriaPadre;

    @ElementCollection
    private List<Long> diasAlquilados;

    public Categoria() {
    }

    public Categoria(String nombre, boolean subCategoria) {
        this.nombre = nombre;
        this.subCategoria = subCategoria;
        this.diasAlquilados = new ArrayList<>();
    }

    public Categoria(String nombre, boolean subCategoria, Categoria categoriaPadre) {
        this.nombre = nombre;
        this.subCategoria = subCategoria;

        if (subCategoria) {
            this.categoriaPadre = categoriaPadre;
        }
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

    public boolean isSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(boolean subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Categoria getCategoriaPadre() {
        return categoriaPadre;
    }

    public void setCategoriaPadre(Categoria categoriaPadre) {
        this.categoriaPadre = categoriaPadre;
    }

    public List<Long> getDiasAlquilados() {
        return diasAlquilados;
    }

    public void setDiasAlquilados(List<Long> diasAlquilados) {
        this.diasAlquilados = diasAlquilados;
    }
}