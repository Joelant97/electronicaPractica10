package electronicapractica10.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Renta implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private Date fechaInicioRenta;
    private Date fechaFinRenta;
    private String estado;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Equipo> equipos;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Cliente cliente;

    private long total;



    public Renta(){

    }

    public Renta(Date fechaInicioRenta, Date fechaFinRenta, String estado, List<Equipo> equipos, Cliente cliente, long total) {
        this.fechaInicioRenta = fechaInicioRenta;
        this.fechaFinRenta = fechaFinRenta;
        this.estado = estado;
        this.equipos = equipos;
        this.cliente = cliente;
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaInicioRenta() {
        return fechaInicioRenta;
    }

    public void setFechaInicioRenta(Date fechaInicioRenta) {
        this.fechaInicioRenta = fechaInicioRenta;
    }

    public Date getFechaFinRenta() {
        return fechaFinRenta;
    }

    public void setFechaFinRenta(Date fechaFinRenta) {
        this.fechaFinRenta = fechaFinRenta;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}


