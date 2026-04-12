package modelo.dao;

import modelo.entities.Proyecto;
import java.util.List;

public interface ProyectoDao {
    Proyecto buscarProyecto(String idProyecto);
    List<Proyecto> findAll();
    int actualizarCosteReal(String idProyecto, double nuevoCoste);
}