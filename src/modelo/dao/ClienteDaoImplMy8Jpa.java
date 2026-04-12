package modelo.dao;

import java.util.List;
<<<<<<< HEAD
import jakarta.persistence.*;
=======

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
>>>>>>> 19a43a3e5704cbdf3b3577fdc6f91f897fe7719d
import modelo.entities.Cliente;

public class ClienteDaoImplMy8Jpa implements ClienteDao {

<<<<<<< HEAD
    private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDaoImplMy8Jpa() {
        // Usamos el nombre de la unidad de persistencia de tu persistence.xml
        emf = Persistence.createEntityManagerFactory("ProyectosJPA");
        em = emf.createEntityManager();
    }

    @Override
    public Cliente buscarCliente(String cif) {
        return em.find(Cliente.class, cif);
    }

    @Override
    public List<Cliente> findAll() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public int insertarCliente(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            return 0;
        }
    }

    @Override
    public int eliminarCliente(String cif) {
        try {
            Cliente c = buscarCliente(cif);
            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            return 0;
        }
    }
=======
	private EntityManagerFactory emf;
	private EntityManager em;

	public ClienteDaoImplMy8Jpa() {
		emf = Persistence.createEntityManagerFactory("ProyectosJPA");
		em = emf.createEntityManager();
	}

	@Override
	public int altaCliente(Cliente cliente) {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Cliente buscarUno(String cif) {
		return em.find(Cliente.class, cif);
	}

	@Override
	public List<Cliente> findAll() {
		TypedQuery<Cliente> query = em.createQuery("select c from Cliente c", Cliente.class);
		return query.getResultList();
	}

	@Override
	public int eliminarCliente(String cif) {
		Cliente c = buscarUno(cif);
		if (c != null) {
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			return 1;
		}
		return 0;
	}
>>>>>>> 19a43a3e5704cbdf3b3577fdc6f91f897fe7719d
}