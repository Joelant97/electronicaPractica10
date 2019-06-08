package electronicapractica10.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Factura implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    @OneToOne
    private Renta renta;

    private int total;

    public Factura() {
    }

    public Factura(Date fecha, Renta renta, int total) {
        this.fecha = fecha;
        this.renta = renta;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Renta getRenta() {
        return renta;
    }

    public void setRenta(Renta renta) {
        this.renta = renta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
