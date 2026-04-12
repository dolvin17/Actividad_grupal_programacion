package modelo.principales;

import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8Jpa;
import modelo.entities.Proyecto;

public class ImprimirGastos {
    public static void main(String[] args) {
        // Instanciamos el DAO para buscar los datos reales
        ProyectoDao pdao = new ProyectoDaoImplMy8Jpa();
        
        // El ID 'FOR2020001' es el que viene en tu script SQL como TERMINADO
        Proyecto p = pdao.buscarProyecto("FOR2020001");

        if (p != null) {
            System.out.println("--- INFORME DE GASTOS REALES (Criterio 5) ---");
            System.out.println("---------------------------------------------");
            System.out.println("CLIENTE: Carlos March (Sede Madrid)");
            System.out.println("PROYECTO: " + p.getIdProyecto() + " - " + p.getDescripcion());
            System.out.println("ESTADO: " + p.getEstado());
            
            System.out.println("\nANÁLISIS FINANCIERO:");
            System.out.println("Importe Venta: " + p.getVentaPrevisto() + " €");
            System.out.println("Gastos Reales: " + p.getCosteReal() + " €");
            System.out.println("Margen Real: " + p.margenReal() + " €");
            System.out.println("Diferencia de días: " + p.diferenciaDiasFinPrevistoReal());
            
            // Punto 193 del PDF: Actualizamos si hay algún cambio
            pdao.actualizarCosteReal(p.getIdProyecto(), 315000.0);
            System.out.println("\nInforme generado con éxito desde la base de datos.");
        } else {
            System.out.println("Error: No se encuentra el proyecto en la base de datos.");
        }
    }
}