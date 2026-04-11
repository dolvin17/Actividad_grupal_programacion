package modelo.dao;

import java.util.List;
import modelo.entities.Cliente;

public interface ClienteDao {
    int insertarCliente(Cliente cliente);
    Cliente buscarCliente(String cif);
    List<Cliente> findAll();
    int eliminarCliente(String cif);
}