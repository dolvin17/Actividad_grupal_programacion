package modelo.entities;

import java.io.Serializable;
<<<<<<< HEAD
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
=======
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto_con_productos")
public class ProyectoConProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_orden")
	private int numOrden;

	@Column(name = "id_proyecto")
	private String idProyecto;

	@Column(name = "id_producto")
	private int idProducto;

	@Column(name = "precio_asignado")
	private int precioAsignado;

	private int cantidad;

	public ProyectoConProducto() {
	}

	public int getNumOrden() {
		return numOrden;
	}

	public void setNumOrden(int numOrden) {
		this.numOrden = numOrden;
	}

	public String getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getPrecioAsignado() {
		return precioAsignado;
	}

	public void setPrecioAsignado(int precioAsignado) {
		this.precioAsignado = precioAsignado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProyectoConProducto))
			return false;
		ProyectoConProducto other = (ProyectoConProducto) obj;
		return numOrden == other.numOrden;
	}

	@Override
	public String toString() {
		return "ProyectoConProducto [numOrden=" + numOrden + ", idProyecto=" + idProyecto + ", cantidad=" + cantidad
				+ "]";
	}
>>>>>>> 19a43a3e5704cbdf3b3577fdc6f91f897fe7719d
}