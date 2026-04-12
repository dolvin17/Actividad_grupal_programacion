package modelo.dao;

import java.util.List;
import jakarta.persistence.*;
import modelo.entities.Proyecto;

public class ProyectoDaoImplMy8Jpa implements ProyectoDao {

    private EntityManager em;

    public ProyectoDaoImplMy8Jpa() {
        // Asegúrate de que "ProyectosJPA" es el nombre que pusiste en persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectosJPA");
        this.em = emf.createEntityManager();
    }

    @Override
    public Proyecto buscarProyecto(String idProyecto) {
        return em.find(Proyecto.class, idProyecto);
    }

    @Override
    public List<Proyecto> findAll() {
        return em.createQuery("SELECT p FROM Proyecto p", Proyecto.class).getResultList();
    }

    @Override
    public int actualizarCosteReal(String idProyecto, double nuevoCoste) {
        try {
            Proyecto p = buscarProyecto(idProyecto);
            if (p != null) {
                em.getTransaction().begin();
                p.setCosteReal(nuevoCoste);
                em.getTransaction().commit();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            return 0;
        }
    }
}