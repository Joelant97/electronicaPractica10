package electronicapractica10.demo.model;

import org.hibernate.annotations.Loader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Categoria subCategoria;
    private long existencia;
    private long costoPorDia;
    //private String foto;
    @Loader
    @Column(name = "foto", columnDefinition = "BLOB")
    private byte[] foto;

    public Equipo() {
    }


    public Equipo(String nombre, Categoria categoria, Categoria subCategoria, long existencia, long costoPorDia, byte[] foto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.subCategoria = subCategoria;
        this.existencia = existencia;
        this.costoPorDia = costoPorDia;
        this.foto = foto;
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

    public Categoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Categoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public long getExistencia() {
        return existencia;
    }

    public void setExistencia(long existencia) {
        this.existencia = existencia;
    }

    public long getCostoPorDia() {
        return costoPorDia;
    }

    public void setCostoPorDia(long costoPorDia) {
        this.costoPorDia = costoPorDia;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
