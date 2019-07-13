package electronicapractica10.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String cedula;
    @Column()
    private String telefono;
    @Column(nullable = true)
    private String correo;

    @Lob
    @Column
    private byte[] foto;

    private Boolean activo;

    public Cliente() {
    }

    public Cliente(String nombre, String cedula, String telefono, String correo, byte[] foto, Boolean activo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.foto = foto;
        this.activo = activo;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public void setActivo(boolean b) {
        this.activo = b;
    }
}
