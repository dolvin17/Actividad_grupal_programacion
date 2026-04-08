package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface ClienteDao {
	int altaCliente(Cliente cliente);

	Cliente buscarUno(String cif);

	List<Cliente> findAll();

	int eliminarCliente(String cif);
}