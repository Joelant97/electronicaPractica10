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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Categoria categoria;

    //@OneToMany(mappedBy = "categoria", orphanRemoval = true)
    //private Collection<Categoria> subCategoria;

    private boolean subCategoria;

    @ElementCollection
    private List<Long> diasRentado;



    public Categoria (){

    }

    public Categoria(String nombre, Categoria categoria, boolean subCategoria, List<Long> diasRentado) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.diasRentado = diasRentado;
    }

    public boolean isSubCategoria() {
        return subCategoria;
    }

    public List<Long> getDiasRentado() {
        return diasRentado;
    }

    public void setDiasRentado(List<Long> diasRentado) {
        this.diasRentado = diasRentado;
    }

    public Categoria(String nombre, boolean subCategoria, Categoria categoria) {
        this.nombre = nombre;
        this.subCategoria = subCategoria;

        if (subCategoria) {
            this.categoria = categoria;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    //Prom. de dias de equipos Rentados:
    public long getPromedioDiasRentado(){
        if(this.diasRentado.size() == 0){
            return 0;
        }

        long suma = 0;
        for(long dias: this.diasRentado){
            suma += dias;
        }
        return suma/this.diasRentado.size();
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

    public void setSubCategoria(boolean subCategoria) {
        this.subCategoria = subCategoria;
    }


}
