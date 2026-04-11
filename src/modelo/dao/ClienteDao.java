package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface ClienteDao {
<<<<<<< HEAD
    int insertarCliente(Cliente cliente);
    Cliente buscarCliente(String cif);
    List<Cliente> findAll();
    int eliminarCliente(String cif);
=======
	int altaCliente(Cliente cliente);

	Cliente buscarUno(String cif);

	List<Cliente> findAll();

	int eliminarCliente(String cif);
>>>>>>> 19a43a3e5704cbdf3b3577fdc6f91f897fe7719d
}