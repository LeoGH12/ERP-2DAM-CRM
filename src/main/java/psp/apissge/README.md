# ApisSGE - Sistema de Gestión Empresarial (SGE)

## 🛠️ Configuración

1.  **Base de Datos**: Asegúrate de tener una instancia de MariaDB corriendo. Por defecto, la aplicación busca una base de datos llamada `erp`.
2.  **Archivo application.properties**: El archivo de configuración se encuentra en `src/main/resources/application.properties`. Los valores predeterminados son:
    ```properties
    spring.datasource.url=jdbc:mariadb://localhost:3306/erp?createDatabaseIfNotExist=true
    spring.datasource.username=root
    spring.datasource.password=root
    ```
    Ajusta el usuario y la contraseña según tu configuración local.

## 🚦 Endpoints Principales

La API se organiza en los siguientes módulos:

### 👥 Clientes (`/api/clientes`)
*   `GET /api/clientes`: Obtener todos los clientes.
*   `GET /api/clientes/{id}`: Obtener un cliente por su ID.
*   `POST /api/clientes`: Crear un nuevo cliente.

### 📝 Tareas (`/api/tareas`)
*   `GET /api/tareas`: Obtener todas las tareas.
*   `GET /api/tareas/{id}`: Obtener una tarea por su ID.
*   `POST /api/tareas`: Crear una nueva tarea.
*   `DELETE /api/tareas/{id}`: Eliminar una tarea.
*   `GET /api/tareas/cliente/{idCliente}`: Filtrar tareas por el ID de un cliente.

### 👤 Usuarios ERP (`/api/usuarios`)
*   `GET /api/usuarios`: Obtener todos los usuarios.
*   `POST /api/usuarios`: Registrar un nuevo usuario.

### 🛡️ Grupos de Usuarios (`/api/v1/grupos-usuarios`)
*   `GET /api/v1/grupos-usuarios`: Listar todos los grupos.
*   `GET /api/v1/grupos-usuarios/{id}`: Obtener detalles de un grupo.
*   `POST /api/v1/grupos-usuarios`: Crear un grupo.
*   `DELETE /api/v1/grupos-usuarios/{id}`: Eliminar un grupo.

### 📢 Campañas de Marketing (`/api/v1/campanas`)
*   `GET /api/v1/campanas`: Listar todas las campañas.
*   `GET /api/v1/campanas/{id}`: Obtener una campaña por ID.
*   `POST /api/v1/campanas`: Crear una nueva campaña.
*   `DELETE /api/v1/campanas/{id}`: Eliminar una campaña.

### 📢 Capacidad para Autenticar (`/api/v1/campanas`)
*   Hace un bloqueo a cualquier peticion que no sea GET sin autenticacion por OAuth2 primero.


## JOSE ANDRES PUEBLA MONTERO