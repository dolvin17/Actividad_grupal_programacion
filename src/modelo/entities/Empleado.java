package modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empl")
	private int idEmpl;

	private String nombre;
	private String apellidos;
	private char genero;
	private String email;
	private String password;
	private double salario;

	@Column(name="id_depar")
	private int idDepar;

	public Empleado() {
	}

	// Metodos propios exigidos en el Anexo 1
	
	public double salarioMensual(int meses) {
		return this.salario / meses; // Calcula el salario prorrateado 
	}

	public String literalGenero() {
		if (Character.toUpperCase(this.genero) == 'H') return "Hombre";
		if (Character.toUpperCase(this.genero) == 'M') return "Mujer";
		return "Desconocido"; // Traduce el caracter de la base de datos [cite: 119]
	}

	public String nombreCompleto() {
		return this.nombre + " " + this.apellidos; // Concatena nombre y apellidos [cite: 120]
	}

	// Getters y Setters
	
	public int getIdEmpl() { return idEmpl; }
	public void setIdEmpl(int idEmpl) { this.idEmpl = idEmpl; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellidos() { return apellidos; }
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }
	public char getGenero() { return genero; }
	public void setGenero(char genero) { this.genero = genero; }
	public double getSalario() { return salario; }
	public void setSalario(double salario) { this.salario = salario; }
	public int getIdDepar() { return idDepar; }
	public void setIdDepar(int idDepar) { this.idDepar = idDepar; }
}