package electronicapractica10.demo.model;

import org.hibernate.annotations.Loader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nombre;
    private String cedula;
    @Loader
    @Column(name = "foto", columnDefinition = "BLOB")
    private byte[] foto;
    private String correo;
    private String telefono;

    public Cliente(){

    }

    public Cliente(String nombre, String cedula, byte[] foto, String correo, String telefono){

        this.nombre = nombre;
        this.cedula = cedula;
        this.foto = foto;
        this.correo = correo;
        this.telefono = telefono;

    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
      return this.nombre + this.cedula + this.telefono;
    }

}


