package electronicapractica10.demo.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rol implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "role")
    private String role;

/*
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "rol_id", nullable = true, updatable = false)
    private Rol rol;
*/

    private boolean deleted = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /*public Rol() {


    }

    public Rol(String role) {
        this.role = role;
    }*/

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}