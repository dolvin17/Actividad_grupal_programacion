package modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="proyecto_con_productos")
public class ProyectoConProducto implements Serializable {
    @Id
    @Column(name="num_orden")
    private int numOrden;
    private int cantidad; // El atributo nuevo que pide el ejercicio

    public ProyectoConProducto() {}

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}