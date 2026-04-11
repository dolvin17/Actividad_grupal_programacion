package modelo.dao;

import java.util.List;
import modelo.entities.Empleado;

public interface EmpleadoDao {
    boolean altaEmpleado(Empleado empleado);
    boolean eliminarEmpleado(int idEmpl);
    Empleado buscarEmpleado(int idEmpl);
    List<Empleado> buscarTodos();
    
    // --- Métodos extraídos del PDF de la Actividad ---
    List<Empleado> empleadosByDepartamento(int idDepar);
    List<Empleado> empleadosByGenero(String sexo);
    List<Empleado> empleadosByApellido(String subcadena);
    double salarioTotal();
    double salarioTotal(int idDepar);
}