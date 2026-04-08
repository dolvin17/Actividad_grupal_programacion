package principales;

import java.util.Scanner;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entities.Cliente;

public class GestionClientes {
	private static Scanner leer = new Scanner(System.in);
	private static ClienteDao cdao = new ClienteDaoImplMy8Jpa();

	public static void main(String[] args) {
		int opcion = 0;
		do {
			System.out.println("\n--- MENÚ GESTIÓN CLIENTES ---");
			System.out.println("1. Alta del Cliente");
			System.out.println("2. Buscar un Cliente");
			System.out.println("3. Mostrar Todos");
			System.out.println("4. Eliminar un cliente");
			System.out.println("5. Salir");
			System.out.print("Selecciona una opción: ");

			opcion = leer.nextInt();
			leer.nextLine();

			switch (opcion) {
			case 1:
				alta();
				break;
			case 2:
				buscar();
				break;
			case 3:
				mostrarTodos();
				break;
			case 4:
				eliminar();
				break;
			}
		} while (opcion != 5);
		System.out.println("¡Programa terminado!");
	}

	private static void alta() {
		Cliente c = new Cliente();
		System.out.print("Introduce CIF: ");
		c.setCif(leer.nextLine());
		System.out.print("Nombre: ");
		c.setNombre(leer.nextLine());
		System.out.print("Apellidos: ");
		c.setApellidos(leer.nextLine());

		if (cdao.altaCliente(c) == 1) {
			System.out.println("Cliente guardado correctamente.");
		} else {
			System.out.println("Error: No se pudo guardar el cliente.");
		}
	}

	private static void buscar() {
		System.out.print("Introduce el CIF a buscar: ");
		Cliente c = cdao.buscarUno(leer.nextLine());
		if (c != null) {
			System.out.println("Encontrado: " + c.getNombre() + " " + c.getApellidos());
		} else {
			System.out.println("Cliente no existe.");
		}
	}

	private static void mostrarTodos() {
		System.out.println("--- LISTA DE CLIENTES ---");
		for (Cliente c : cdao.findAll()) {
			System.out.println(c.getCif() + " - " + c.getNombre());
		}
	}

	private static void eliminar() {
		System.out.print("Introduce el CIF del cliente a borrar: ");
		if (cdao.eliminarCliente(leer.nextLine()) == 1) {
			System.out.println("Cliente eliminado.");
		} else {
			System.out.println("No se pudo eliminar (no existe).");
		}
	}
}