package modelo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import modelo.entities.Cliente;

public class ClienteDaoImplMy8Jpa implements ClienteDao {

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
}