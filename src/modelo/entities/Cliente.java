package modelo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cif;
	private String nombre;
	private String apellidos;
	private String domicilio;
	
	@Column(name="facturacion_anual")
	private BigDecimal facturacionAnual;
	
	@Column(name="numero_empleados")
	private Integer numeroEmpleados;

	public Cliente() {
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public BigDecimal getFacturacionAnual() {
		return facturacionAnual;
	}

	public void setFacturacionAnual(BigDecimal facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public Integer getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(Integer numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Cliente)) return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + "]";
	}
}