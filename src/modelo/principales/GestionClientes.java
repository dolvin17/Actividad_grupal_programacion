package modelo.principales;

import java.util.Scanner;
import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplMy8Jpa;
import modelo.entities.Cliente;

public class GestionClientes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClienteDao cdao = new ClienteDaoImplMy8Jpa();
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Alta del Cliente");
            System.out.println("2. Buscar un Cliente");
            System.out.println("3. Mostrar Todos");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Funcionalidad de alta (rellenar objeto cliente)");
                    break;
                case 2:
                    System.out.print("Introduce el CIF: ");
                    String cif = sc.next();
                    Cliente cli = cdao.buscarCliente(cif);
                    System.out.println(cli != null ? cli.getNombre() + " " + cli.getApellidos() : "No existe");
                    break;
                case 3:
                    for (Cliente c : cdao.findAll()) {
                        System.out.println(c.getCif() + " - " + c.getNombre());
                    }
                    break;
                case 4:
                    System.out.print("CIF a eliminar: ");
                    cdao.eliminarCliente(sc.next());
                    break;
            }
        }
        sc.close();
    }
}