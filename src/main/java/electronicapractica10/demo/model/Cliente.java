package electronicapractica10.demo.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Entity
public class Cliente implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String cedula;
    private String foto;
    private String correo;
    private String telefono;

    public Cliente(){

    }

    public Cliente(String nombre, String cedula, String foto, String correo, String telefono){

        this.nombre = nombre;
        this.cedula = cedula;
        this.foto = foto;
        this.correo = correo;
        this.telefono = telefono;

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
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
}


