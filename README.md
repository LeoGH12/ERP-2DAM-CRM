# Módulo CRM - API REST (Usuarios y Actividades)

## Descripción
Este submódulo gestiona la parte operativa del CRM, específicamente la gestión de **Usuarios del ERP** (agentes) y el registro de **Actividades** (interacciones con clientes).

## Tecnologías
* Spring Boot
* Spring Data JPA (Hibernate)
* MariaDB
* Lombok

## Estructura de Datos
Se han implementado las siguientes tablas siguiendo el esquema del ERP:

1.  **USUARIOS_ERP**: Almacena las credenciales y vinculación con la tabla `EMPLEADO`.
2.  **ACTIVIDADES**: Registra eventos (llamadas, reuniones) vinculando un `CLIENTE` y un `USUARIO_ERP`.

## Endpoints API

### 1. Usuarios (`/api/v1/crm/usuarios`)
* **GET /**: Lista todos los usuarios. Retorna DTO ligero (sin datos sensibles anidados).
* **GET /{id}**: Obtiene detalle de un usuario.
* **POST /**: Crea un usuario nuevo.
    * *Body*: `{ "email": "a@b.com", "password": "123", "idEmpleado": 1 }`
* **PUT /{id}**: Actualiza usuario existente.
* **DELETE /{id}**: Elimina usuario.

### 2. Actividades (`/api/v1/crm/actividades`)
* **GET /**: Lista todas las actividades registradas.
* **GET /{id}**: Detalle de una actividad.
* **POST /**: Registra nueva actividad.
    * *Body*: `{ "fecha": "2025-10-10", "descripcion": "Llamada venta", "idCliente": 5, "idUsuario": 2 }`
* **PUT /{id}**: Edita actividad.
* **DELETE /{id}**: Borra actividad.

## Relaciones y DTOs
Se ha optado por una estrategia de **DTOs planos (Caso A)** para evitar recursividad infinita en el JSON:
* Al pedir una `Actividad`, se devuelve `idCliente` (Integer), no el objeto `Cliente` completo.
* Al pedir un `Usuario`, se devuelve `idEmpleado` (Integer).
* Esto optimiza la transferencia de datos y desacopla la lectura de las tablas maestras pesadas.