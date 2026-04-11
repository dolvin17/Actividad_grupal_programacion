package modelo.principales;

import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8Jpa;
import modelo.entities.Empleado;

public class TestEmpleado {
    public static void main(String[] args) {
        try {
            EmpleadoDao dao = new EmpleadoDaoImplMy8Jpa();
            
            System.out.println("Buscando al empleado 100...");
            Empleado emp = dao.buscarEmpleado(100);
            
            if (emp != null) {
                System.out.println("¡ÉXITO! Conexión y búsqueda correctas.");
                System.out.println("Nombre: " + emp.nombreCompleto());
                System.out.println("Género: " + emp.literalGenero());
                System.out.println("Salario de la empresa: " + dao.salarioTotal());
            } else {
                System.out.println("Atención: Conexión realizada pero el ID 100 no existe en la tabla.");
            }
        } catch (Exception e) {
            System.out.println("Error crítico en la ejecución:");
            e.printStackTrace();
        }
    }
}