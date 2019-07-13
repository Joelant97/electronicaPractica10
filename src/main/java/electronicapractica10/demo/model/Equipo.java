package electronicapractica10.demo.model;

import org.hibernate.annotations.Loader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Equipo implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private int tarifa;

    @Loader
    @Column(name = "imagen", columnDefinition = "BLOB")
    private byte[] imagen;

    private String familia;

    private String subFamilia;

    private Boolean activo;

    private int cantidad;

    public Equipo() {
    }

    public Equipo(String nombre, int tarifa, byte[] foto, String familia, String subFamilia, Boolean activo, int cantidad) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.imagen = foto;
        this.familia = familia;
        this.subFamilia = subFamilia;
        this.activo = activo;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(String subFamilia) {
        this.subFamilia = subFamilia;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
