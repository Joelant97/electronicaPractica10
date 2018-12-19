package electronicapractica10.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    private boolean isAdmin;
    @Column(name = "password")
    private String password;
    @Column(name = "telefono")
    private String telefono;
    private boolean activo;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Rol> roles;

    public Usuario(String username, boolean isAdmin, String password, String telefono, boolean activo, Set<Rol> roles) {
        this.username = username;
        this.isAdmin = isAdmin;
        this.password = password;
        this.telefono = telefono;
        this.activo = activo;
        this.roles = roles;

    }

    public Usuario() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}