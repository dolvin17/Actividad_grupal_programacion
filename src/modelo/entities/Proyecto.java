package modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name="proyectos")
public class Proyecto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_proyecto")
    private String idProyecto;
    private String descripcion;
    
    @Column(name="venta_previsto")
    private double ventaPrevisto;
    @Column(name="costes_previsto")
    private double costesPrevisto;
    @Column(name="coste_real")
    private double costeReal;
    
    private String estado;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_fin_previsto")
    private Date fechaFinPrevisto;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_fin_real")
    private Date fechaFinReal;

    public Proyecto() {}

    // Métodos de cálculo requeridos por la actividad 
    public double margenPrevisto() {
        return ventaPrevisto - costesPrevisto;
    }

    public double porcentageMargenPrevisto() {
        return (ventaPrevisto != 0) ? (margenPrevisto() / ventaPrevisto) * 100 : 0;
    }

    public double margenReal() {
        return ventaPrevisto - costeReal;
    }

    public double diferenciaGastos() {
        return costeReal - costesPrevisto;
    }

    public int diferenciaDiasFinPrevistoReal() {
        if (fechaFinPrevisto == null || fechaFinReal == null) return 0;
        return (int) ChronoUnit.DAYS.between(
            fechaFinPrevisto.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
            fechaFinReal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );
    }

    // Getters necesarios para que ImprimirGastos no de error
    public String getIdProyecto() { return idProyecto; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }
    public double getVentaPrevisto() { return ventaPrevisto; }
    public double getCostesPrevisto() { return costesPrevisto; }
    public double getCosteReal() { return costeReal; }
    public void setCosteReal(double costeReal) { this.costeReal = costeReal; }
}