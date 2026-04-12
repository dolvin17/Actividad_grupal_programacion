package modelo.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import modelo.entities.Empleado;

public class EmpleadoDaoImplMy8Jpa implements EmpleadoDao {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public EmpleadoDaoImplMy8Jpa() {
        // Aquí conectamos con la misma base de datos que usó Karol
        emf = Persistence.createEntityManagerFactory("ProyectosJPA"); 
        em = emf.createEntityManager();
    }

    @Override
    public boolean altaEmpleado(Empleado empleado) {
        try {
            em.getTransaction().begin();
            em.persist(empleado);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(int idEmpl) {
        try {
            Empleado emp = buscarEmpleado(idEmpl);
            if (emp != null) {
                em.getTransaction().begin();
                em.remove(emp);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Empleado buscarEmpleado(int idEmpl) {
        return em.find(Empleado.class, idEmpl);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Empleado> buscarTodos() {
        return em.createQuery("select e from Empleado e").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Empleado> empleadosByDepartamento(int idDepar) {
        return em.createQuery("select e from Empleado e where e.idDepar = :id")
                 .setParameter("id", idDepar)
                 .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Empleado> empleadosByGenero(String sexo) {
        return em.createQuery("select e from Empleado e where e.genero = :sexo")
                 .setParameter("sexo", sexo)
                 .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Empleado> empleadosByApellido(String subcadena) {
        return em.createQuery("select e from Empleado e where e.apellidos like :sub")
                 .setParameter("sub", "%" + subcadena + "%")
                 .getResultList();
    }

    @Override
    public double salarioTotal() {
        Query query = em.createQuery("select sum(e.salario) from Empleado e");
        Double result = (Double) query.getSingleResult();
        return result != null ? result : 0.0;
    }

    @Override
    public double salarioTotal(int idDepar) {
        Query query = em.createQuery("select sum(e.salario) from Empleado e where e.idDepar = :id")
                 .setParameter("id", idDepar);
        Double result = (Double) query.getSingleResult();
        return result != null ? result : 0.0;
    }
}