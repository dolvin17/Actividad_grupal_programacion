# Gestión de Proyectos - Actividad Grupal 3

Este repositorio contiene la implementación de una aplicación Java para la gestión de clientes, productos y recursos humanos utilizando **JPA (Jakarta Persistence)**.

## Tecnologías utilizadas
* **Lenguaje:** Java 21
* **Persistencia:** JPA 3.0 (EclipseLink 4.0.8)
* **Base de Datos:** MySQL (Servidor XAMPP)
* **Gestión de Dependencias:** Librerías JAR incluidas en carpeta `/lib`

## Estructura del Proyecto
El proyecto sigue el patrón de diseño **DAO (Data Access Object)** para separar la lógica de negocio de la base de datos.

* `modelo.entities`: Clases que representan las tablas de la BD (Cliente, Producto, ProyectoConProducto).
* `modelo.dao`: Interfaces y clases con la lógica CRUD.
* `principales`: Punto de entrada de la aplicación con menús por consola.
* `META-INF`: Archivo `persistence.xml` con la configuración de la unidad de persistencia.

##  Módulos Implementados

### Parte 1: Gestión de Clientes y Productos
- [x] Configuración inicial del entorno JPA y conexión a base de datos.
- [x] Mapeo de la entidad **Cliente** y **Producto**.
- [x] Modificación del modelo físico: Añadida columna `cantidad` en `proyecto_con_productos`.
- [x] Implementación de **ClienteDao** (Alta, Baja, Búsqueda y Listado).
- [x] Interfaz de usuario por consola para operaciones de Clientes.

### Parte 2: Recursos Humanos (En proceso...)
- [ ] Mapeo de entidades **Empleado** y **Departamento**.
- [ ] Implementación de lógica DAO para RRHH.
- [ ] Integración en el menú principal.

## ⚙️ Configuración del Entorno
1. Importar el proyecto en Eclipse como un proyecto Java estándar.
2. Asegurarse de que los JAR de la carpeta `/lib` estén en el **Build Path**.
3. Iniciar **MySQL** desde el panel de XAMPP.
4. Crear la base de datos `proyectos_FP_2025` y ejecutar el script SQL proporcionado.
5. El archivo `persistence.xml` está configurado para usuario `root` sin contraseña.

##
