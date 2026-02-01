CREATE DATABASE IF NOT EXISTS ERP_completo CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;
USE ERP_completo;

-- =======================================================
-- NIVEL 0: TABLAS MAESTRAS (INDEPENDIENTES)
-- Estas tablas no tienen claves foráneas (FK) a otras tablas
-- =======================================================

CREATE TABLE ALMACEN (
                         id_almacen int(11) NOT NULL AUTO_INCREMENT,
                         nombre varchar(100) DEFAULT NULL,
                         ubicacion varchar(200) DEFAULT NULL,
                         PRIMARY KEY (id_almacen)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE BANCOS (
                        id_banco int(11) NOT NULL AUTO_INCREMENT,
                        nombre_banco varchar(100) DEFAULT NULL,
                        codigo_swift varchar(50) DEFAULT NULL,
                        PRIMARY KEY (id_banco)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CATEGORIAS_TICKETS (
                                    id_categoria int(11) NOT NULL AUTO_INCREMENT,
                                    nombre_categoria varchar(100) DEFAULT NULL,
                                    PRIMARY KEY (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CATEGORIA_GASTO (
                                 categoria_id int(11) NOT NULL AUTO_INCREMENT,
                                 nombre varchar(100) DEFAULT NULL,
                                 politica text DEFAULT NULL,
                                 PRIMARY KEY (categoria_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CATEGORIA_PRODUCTO (
                                    id_categoria int(11) NOT NULL AUTO_INCREMENT,
                                    nombre varchar(100) DEFAULT NULL,
                                    PRIMARY KEY (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CATEGORIA_PROFESIONAL (
                                       id_categoria_p int(11) NOT NULL AUTO_INCREMENT,
                                       descripcion varchar(255) DEFAULT NULL,
                                       nombre_cargo varchar(100) DEFAULT NULL,
                                       salario_bruto decimal(10,2) DEFAULT NULL,
                                       PRIMARY KEY (id_categoria_p)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CLIENTES (
                          id_cliente int(11) NOT NULL AUTO_INCREMENT,
                          nombre varchar(100) NOT NULL,
                          fecha_alta date DEFAULT NULL,
                          estado varchar(50) DEFAULT NULL,
                          PRIMARY KEY (id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE GRUPOS (
                        id_grupo int(11) NOT NULL AUTO_INCREMENT,
                        nombre varchar(100) DEFAULT NULL,
                        descripcion varchar(255) DEFAULT NULL,
                        PRIMARY KEY (id_grupo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE IMPUESTO (
                          id_impuesto int(11) NOT NULL AUTO_INCREMENT,
                          nombre varchar(50) DEFAULT NULL,
                          porcentaje decimal(5,2) DEFAULT NULL,
                          PRIMARY KEY (id_impuesto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE INVENTARIO (
                            id_inventario int(11) NOT NULL AUTO_INCREMENT,
                            nombre varchar(100) DEFAULT NULL,
                            stock_actual int(11) DEFAULT NULL,
                            stock_maximo int(11) DEFAULT NULL,
                            stock_minimo int(11) DEFAULT NULL,
                            PRIMARY KEY (id_inventario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE METODO_PAGO (
                             metodo_id int(11) NOT NULL AUTO_INCREMENT,
                             nombre varchar(50) DEFAULT NULL,
                             PRIMARY KEY (metodo_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PERMISO (
                         id_permiso int(11) NOT NULL AUTO_INCREMENT,
                         nombre varchar(50) DEFAULT NULL,
                         descripcion varchar(200) DEFAULT NULL,
                         PRIMARY KEY (id_permiso)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PRIORIDADES_TICKETS (
                                     id_prioridad int(11) NOT NULL AUTO_INCREMENT,
                                     grado_prioridad varchar(50) DEFAULT NULL,
                                     PRIMARY KEY (id_prioridad)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PRODUCTO (
                          id_producto int(11) NOT NULL AUTO_INCREMENT,
                          nombre varchar(100) DEFAULT NULL,
                          stock int(11) DEFAULT NULL,
                          color varchar(50) DEFAULT NULL,
                          precio decimal(10,2) DEFAULT NULL,
                          PRIMARY KEY (id_producto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PROVEEDOR (
                           id_proveedor int(11) NOT NULL AUTO_INCREMENT,
                           nombre varchar(100) DEFAULT NULL,
                           correo varchar(100) DEFAULT NULL,
                           telefono varchar(20) DEFAULT NULL,
                           descripcion text DEFAULT NULL,
                           PRIMARY KEY (id_proveedor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE REGISTRO (
                          id_registro int(11) NOT NULL AUTO_INCREMENT,
                          nombre varchar(100) DEFAULT NULL,
                          cantidad_comprada int(11) DEFAULT NULL,
                          fecha datetime DEFAULT NULL,
                          recibido tinyint(1) DEFAULT NULL,
                          PRIMARY KEY (id_registro)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE TIPO_DOCUMENTO (
                                id_tipo int(11) NOT NULL AUTO_INCREMENT,
                                nombre varchar(100) DEFAULT NULL,
                                PRIMARY KEY (id_tipo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE VENDEDOR (
                          id_vendedor int(11) NOT NULL AUTO_INCREMENT,
                          nombre_vendedor varchar(100) DEFAULT NULL,
                          correo varchar(100) DEFAULT NULL,
                          zona_comercial varchar(100) DEFAULT NULL,
                          PRIMARY KEY (id_vendedor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- =======================================================
-- NIVEL 1: DEPENDENCIAS DE PRIMER NIVEL
-- Dependen solo de las tablas del Nivel 0
-- =======================================================

CREATE TABLE CAMPAÑA_MARKETING (
                                   id_campaña int(11) NOT NULL AUTO_INCREMENT,
                                   id_grupo int(11) DEFAULT NULL,
                                   nombre varchar(100) DEFAULT NULL,
                                   tipo varchar(50) DEFAULT NULL,
                                   fecha_inicio date DEFAULT NULL,
                                   fecha_fin date DEFAULT NULL,
                                   presupuesto decimal(10,2) DEFAULT NULL,
                                   estado varchar(50) DEFAULT NULL,
                                   PRIMARY KEY (id_campaña),
                                   KEY id_grupo (id_grupo),
                                   CONSTRAINT campaña_marketing_ibfk_1 FOREIGN KEY (id_grupo) REFERENCES GRUPOS (id_grupo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CONTACTOS (
                           id_contacto int(11) NOT NULL AUTO_INCREMENT,
                           id_cliente int(11) DEFAULT NULL,
                           nombre varchar(100) DEFAULT NULL,
                           email varchar(100) DEFAULT NULL,
                           telefono varchar(20) DEFAULT NULL,
                           direccion varchar(200) DEFAULT NULL,
                           cargo varchar(50) DEFAULT NULL,
                           tipo varchar(50) DEFAULT NULL,
                           PRIMARY KEY (id_contacto),
                           KEY id_cliente (id_cliente),
                           CONSTRAINT contactos_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES CLIENTES (id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CUENTAS_BANCARIAS (
                                   id_cuenta int(11) NOT NULL AUTO_INCREMENT,
                                   id_banco int(11) DEFAULT NULL,
                                   numero_iban varchar(50) DEFAULT NULL,
                                   saldo decimal(15,2) DEFAULT NULL,
                                   titular varchar(100) DEFAULT NULL,
                                   PRIMARY KEY (id_cuenta),
                                   KEY id_banco (id_banco),
                                   CONSTRAINT cuentas_bancarias_ibfk_1 FOREIGN KEY (id_banco) REFERENCES BANCOS (id_banco)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE EMPLEADO (
                          id_empleado int(11) NOT NULL AUTO_INCREMENT,
                          id_categoria int(11) NOT NULL,
                          nombre varchar(100) NOT NULL,
                          dni varchar(20) DEFAULT NULL,
                          telefono varchar(100) DEFAULT NULL,
                          email varchar(100) DEFAULT NULL,
                          direccion varchar(200) DEFAULT NULL,
                          departamento varchar(50) DEFAULT NULL,
                          rol varchar(50) DEFAULT NULL,
                          nuss varchar(20) DEFAULT NULL,
                          es_aprobador tinyint(1) DEFAULT 0,
                          PRIMARY KEY (id_empleado),
                          KEY EMPLEADO_CATEGORIA_PROFESIONAL_FK (id_categoria),
                          CONSTRAINT EMPLEADO_CATEGORIA_PROFESIONAL_FK FOREIGN KEY (id_categoria) REFERENCES CATEGORIA_PROFESIONAL (id_categoria_p)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE INVENTARIO_ALMACEN (
                                    id_inventario int(11) NOT NULL,
                                    id_almacen int(11) NOT NULL,
                                    PRIMARY KEY (id_inventario,id_almacen),
                                    KEY id_almacen (id_almacen),
                                    CONSTRAINT inventario_almacen_ibfk_1 FOREIGN KEY (id_inventario) REFERENCES INVENTARIO (id_inventario),
                                    CONSTRAINT inventario_almacen_ibfk_2 FOREIGN KEY (id_almacen) REFERENCES ALMACEN (id_almacen)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PRODUCTO_CATEGORIA (
                                    id_producto int(11) NOT NULL,
                                    id_categoria int(11) NOT NULL,
                                    PRIMARY KEY (id_producto,id_categoria),
                                    KEY id_categoria (id_categoria),
                                    CONSTRAINT producto_categoria_ibfk_1 FOREIGN KEY (id_producto) REFERENCES PRODUCTO (id_producto),
                                    CONSTRAINT producto_categoria_ibfk_2 FOREIGN KEY (id_categoria) REFERENCES CATEGORIA_PRODUCTO (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PRODUCTO_INVENTARIO (
                                     id_producto int(11) NOT NULL,
                                     id_inventario int(11) NOT NULL,
                                     PRIMARY KEY (id_producto,id_inventario),
                                     KEY id_inventario (id_inventario),
                                     CONSTRAINT producto_inventario_ibfk_1 FOREIGN KEY (id_producto) REFERENCES PRODUCTO (id_producto),
                                     CONSTRAINT producto_inventario_ibfk_2 FOREIGN KEY (id_inventario) REFERENCES INVENTARIO (id_inventario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PROVEEDOR_PRODUCTO (
                                    id_proveedor int(11) NOT NULL,
                                    id_producto int(11) NOT NULL,
                                    PRIMARY KEY (id_proveedor,id_producto),
                                    KEY id_producto (id_producto),
                                    CONSTRAINT proveedor_producto_ibfk_1 FOREIGN KEY (id_proveedor) REFERENCES PROVEEDOR (id_proveedor),
                                    CONSTRAINT proveedor_producto_ibfk_2 FOREIGN KEY (id_producto) REFERENCES PRODUCTO (id_producto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE REGISTRO_INVENTARIO (
                                     id_registro int(11) NOT NULL,
                                     id_inventario int(11) NOT NULL,
                                     PRIMARY KEY (id_registro,id_inventario),
                                     KEY id_inventario (id_inventario),
                                     CONSTRAINT registro_inventario_ibfk_1 FOREIGN KEY (id_registro) REFERENCES REGISTRO (id_registro),
                                     CONSTRAINT registro_inventario_ibfk_2 FOREIGN KEY (id_inventario) REFERENCES INVENTARIO (id_inventario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- =======================================================
-- NIVEL 2: DEPENDENCIAS DE SEGUNDO NIVEL
-- Dependen de tablas del Nivel 1 (y opcionalmente Nivel 0)
-- =======================================================

CREATE TABLE DIRECCION_ENVIO (
                                 id_direccion int(11) NOT NULL AUTO_INCREMENT,
                                 id_contacto int(11) DEFAULT NULL,
                                 direccion varchar(255) DEFAULT NULL,
                                 ciudad varchar(100) DEFAULT NULL,
                                 pais varchar(100) DEFAULT NULL,
                                 codigo_postal varchar(20) DEFAULT NULL,
                                 PRIMARY KEY (id_direccion),
                                 KEY id_contacto (id_contacto),
                                 CONSTRAINT direccion_envio_ibfk_1 FOREIGN KEY (id_contacto) REFERENCES CONTACTOS (id_contacto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE GASTO (
                       id_gasto int(11) NOT NULL AUTO_INCREMENT,
                       id_empleado int(11) DEFAULT NULL,
                       id_categoria int(11) DEFAULT NULL,
                       id_metodopago int(11) DEFAULT NULL,
                       fecha datetime DEFAULT NULL,
                       concepto varchar(200) DEFAULT NULL,
                       importe_bruto decimal(10,2) DEFAULT NULL,
                       importe_neto decimal(10,2) DEFAULT NULL,
                       estado varchar(20) DEFAULT NULL,
                       PRIMARY KEY (id_gasto),
                       KEY id_empleado (id_empleado),
                       KEY id_categoria (id_categoria),
                       KEY id_metodopago (id_metodopago),
                       CONSTRAINT gasto_ibfk_1 FOREIGN KEY (id_empleado) REFERENCES EMPLEADO (id_empleado),
                       CONSTRAINT gasto_ibfk_2 FOREIGN KEY (id_categoria) REFERENCES CATEGORIA_GASTO (categoria_id),
                       CONSTRAINT gasto_ibfk_3 FOREIGN KEY (id_metodopago) REFERENCES METODO_PAGO (metodo_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE MOVIMIENTOS_BANCARIOS (
                                       id_movimiento int(11) NOT NULL AUTO_INCREMENT,
                                       id_cuenta int(11) DEFAULT NULL,
                                       fecha_operacion date DEFAULT NULL,
                                       tipo varchar(50) DEFAULT NULL,
                                       importe decimal(15,2) DEFAULT NULL,
                                       concepto varchar(255) DEFAULT NULL,
                                       referencia_bancaria varchar(100) DEFAULT NULL,
                                       estado_conciliacion tinyint(1) DEFAULT NULL,
                                       PRIMARY KEY (id_movimiento),
                                       KEY id_cuenta (id_cuenta),
                                       CONSTRAINT movimientos_bancarios_ibfk_1 FOREIGN KEY (id_cuenta) REFERENCES CUENTAS_BANCARIAS (id_cuenta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE NOMINA (
                        id_nomina int(11) NOT NULL AUTO_INCREMENT,
                        id_empleado int(11) DEFAULT NULL,
                        id_cargo int(11) DEFAULT NULL,
                        salario_bruto decimal(10,2) DEFAULT NULL,
                        periodo varchar(50) DEFAULT NULL,
                        fecha_pago date DEFAULT NULL,
                        salario_neto decimal(10,2) DEFAULT NULL,
                        deducciones decimal(10,2) DEFAULT NULL,
                        PRIMARY KEY (id_nomina),
                        KEY id_empleado (id_empleado),
                        KEY id_cargo (id_cargo),
                        CONSTRAINT nomina_ibfk_2 FOREIGN KEY (id_cargo) REFERENCES CATEGORIA_PROFESIONAL (id_categoria_p)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE USUARIOS_ERP (
                              id_usuario int(11) NOT NULL AUTO_INCREMENT,
                              id_empleado int(11) DEFAULT NULL,
                              email varchar(100) NOT NULL,
                              password varchar(256) NOT NULL,
                              PRIMARY KEY (id_usuario),
                              KEY id_empleado (id_empleado),
                              CONSTRAINT usuarios_erp_ibfk_1 FOREIGN KEY (id_empleado) REFERENCES EMPLEADO (id_empleado)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- =======================================================
-- NIVEL 3: DEPENDENCIAS DE TERCER NIVEL
-- Dependen de tablas del Nivel 2 (como USUARIOS_ERP o GASTO)
-- =======================================================

CREATE TABLE ACTIVIDADES (
                             id_actividad int(11) NOT NULL AUTO_INCREMENT,
                             id_cliente int(11) DEFAULT NULL,
                             id_usuario int(11) DEFAULT NULL,
                             fecha date DEFAULT NULL,
                             descripcion text DEFAULT NULL,
                             PRIMARY KEY (id_actividad),
                             KEY id_cliente (id_cliente),
                             KEY id_usuario (id_usuario),
                             CONSTRAINT actividades_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES CLIENTES (id_cliente),
                             CONSTRAINT actividades_ibfk_2 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE CENTRO_COSTE (
                              cc_id int(11) NOT NULL AUTO_INCREMENT,
                              gasto_id int(11) DEFAULT NULL,
                              codigo varchar(50) DEFAULT NULL,
                              nombre varchar(100) DEFAULT NULL,
                              PRIMARY KEY (cc_id),
                              KEY gasto_id (gasto_id),
                              CONSTRAINT centro_coste_ibfk_1 FOREIGN KEY (gasto_id) REFERENCES GASTO (id_gasto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE DOCUMENTO (
                           id_documento int(11) NOT NULL AUTO_INCREMENT,
                           id_tipo int(11) DEFAULT NULL,
                           id_usuario int(11) DEFAULT NULL,
                           id_permiso int(11) DEFAULT NULL,
                           nombre varchar(100) DEFAULT NULL,
                           descripcion text DEFAULT NULL,
                           fecha_creacion date DEFAULT NULL,
                           fecha_modificacion date DEFAULT NULL,
                           PRIMARY KEY (id_documento),
                           KEY id_tipo (id_tipo),
                           KEY id_usuario (id_usuario),
                           KEY id_permiso (id_permiso),
                           CONSTRAINT documento_ibfk_1 FOREIGN KEY (id_tipo) REFERENCES TIPO_DOCUMENTO (id_tipo),
                           CONSTRAINT documento_ibfk_2 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario),
                           CONSTRAINT documento_ibfk_3 FOREIGN KEY (id_permiso) REFERENCES PERMISO (id_permiso)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE GASTO_IMPUESTO (
                                gasto_impuesto_id int(11) NOT NULL AUTO_INCREMENT,
                                gasto_id int(11) DEFAULT NULL,
                                impuesto_id int(11) DEFAULT NULL,
                                base decimal(10,2) DEFAULT NULL,
                                cuota decimal(10,2) DEFAULT NULL,
                                total decimal(10,2) DEFAULT NULL,
                                PRIMARY KEY (gasto_impuesto_id),
                                KEY gasto_id (gasto_id),
                                KEY impuesto_id (impuesto_id),
                                CONSTRAINT gasto_impuesto_ibfk_1 FOREIGN KEY (gasto_id) REFERENCES GASTO (id_gasto),
                                CONSTRAINT gasto_impuesto_ibfk_2 FOREIGN KEY (impuesto_id) REFERENCES IMPUESTO (id_impuesto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE GRUPO_USUARIO (
                               id_grupo int(11) NOT NULL,
                               id_usuario int(11) NOT NULL,
                               PRIMARY KEY (id_grupo,id_usuario),
                               KEY id_usuario (id_usuario),
                               CONSTRAINT grupo_usuario_ibfk_1 FOREIGN KEY (id_grupo) REFERENCES GRUPOS (id_grupo),
                               CONSTRAINT grupo_usuario_ibfk_2 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE OPORTUNIDADES (
                               id_oportunidad int(11) NOT NULL AUTO_INCREMENT,
                               id_cliente int(11) DEFAULT NULL,
                               id_usuario int(11) DEFAULT NULL,
                               nombre varchar(100) DEFAULT NULL,
                               estado varchar(50) DEFAULT NULL,
                               valor_estimado decimal(10,2) DEFAULT NULL,
                               fecha_creacion date DEFAULT NULL,
                               fecha_fin date DEFAULT NULL,
                               PRIMARY KEY (id_oportunidad),
                               KEY id_cliente (id_cliente),
                               KEY id_usuario (id_usuario),
                               CONSTRAINT oportunidades_ibfk_1 FOREIGN KEY (id_cliente) REFERENCES CLIENTES (id_cliente),
                               CONSTRAINT oportunidades_ibfk_2 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PEDIDO (
                        id_pedido int(11) NOT NULL AUTO_INCREMENT,
                        id_contacto int(11) DEFAULT NULL,
                        id_vendedor int(11) DEFAULT NULL,
                        id_metodopago int(11) DEFAULT NULL,
                        id_direccionenvio int(11) DEFAULT NULL,
                        fecha_pedido date DEFAULT NULL,
                        total decimal(10,2) DEFAULT NULL,
                        estado_pedido varchar(50) DEFAULT NULL,
                        PRIMARY KEY (id_pedido),
                        KEY id_contacto (id_contacto),
                        KEY id_vendedor (id_vendedor),
                        KEY id_metodopago (id_metodopago),
                        KEY id_direccionenvio (id_direccionenvio),
                        CONSTRAINT pedido_ibfk_1 FOREIGN KEY (id_contacto) REFERENCES CONTACTOS (id_contacto),
                        CONSTRAINT pedido_ibfk_2 FOREIGN KEY (id_vendedor) REFERENCES VENDEDOR (id_vendedor),
                        CONSTRAINT pedido_ibfk_3 FOREIGN KEY (id_metodopago) REFERENCES METODO_PAGO (metodo_id),
                        CONSTRAINT pedido_ibfk_4 FOREIGN KEY (id_direccionenvio) REFERENCES DIRECCION_ENVIO (id_direccion)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE TAREAS (
                        id_tarea int(11) NOT NULL AUTO_INCREMENT,
                        id_usuario int(11) DEFAULT NULL,
                        id_cliente int(11) DEFAULT NULL,
                        descripcion text DEFAULT NULL,
                        fecha_asignacion date DEFAULT NULL,
                        fecha_vencimiento date DEFAULT NULL,
                        estado varchar(50) DEFAULT NULL,
                        PRIMARY KEY (id_tarea),
                        KEY id_usuario (id_usuario),
                        KEY id_cliente (id_cliente),
                        CONSTRAINT tareas_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario),
                        CONSTRAINT tareas_ibfk_2 FOREIGN KEY (id_cliente) REFERENCES CLIENTES (id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE TICKETS (
                         id_ticket int(11) NOT NULL AUTO_INCREMENT,
                         id_usuario int(11) DEFAULT NULL,
                         id_prioridad int(11) DEFAULT NULL,
                         id_categoria int(11) DEFAULT NULL,
                         asunto varchar(200) DEFAULT NULL,
                         descripcion text DEFAULT NULL,
                         estado varchar(50) DEFAULT NULL,
                         fecha_inicial date DEFAULT NULL,
                         fecha_estimada date DEFAULT NULL,
                         fecha_final date DEFAULT NULL,
                         PRIMARY KEY (id_ticket),
                         KEY id_usuario (id_usuario),
                         KEY id_prioridad (id_prioridad),
                         KEY id_categoria (id_categoria),
                         CONSTRAINT tickets_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario),
                         CONSTRAINT tickets_ibfk_2 FOREIGN KEY (id_prioridad) REFERENCES PRIORIDADES_TICKETS (id_prioridad),
                         CONSTRAINT tickets_ibfk_3 FOREIGN KEY (id_categoria) REFERENCES CATEGORIAS_TICKETS (id_categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- =======================================================
-- NIVEL 4: DEPENDENCIAS DE CUARTO Y QUINTO NIVEL
-- Tablas detalle, históricos, facturas, cobros y pagos
-- =======================================================

CREATE TABLE COBROS_CLIENTES (
                                 id_cobro int(11) NOT NULL AUTO_INCREMENT,
                                 id_pedido int(11) DEFAULT NULL,
                                 id_movimiento int(11) DEFAULT NULL,
                                 fecha_cobro datetime DEFAULT NULL,
                                 monto_cobrado decimal(10,2) DEFAULT NULL,
                                 PRIMARY KEY (id_cobro),
                                 KEY id_pedido (id_pedido),
                                 KEY id_movimiento (id_movimiento),
                                 CONSTRAINT cobros_clientes_ibfk_1 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido),
                                 CONSTRAINT cobros_clientes_ibfk_2 FOREIGN KEY (id_movimiento) REFERENCES MOVIMIENTOS_BANCARIOS (id_movimiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE COMENTARIO (
                            id_comentario int(11) NOT NULL AUTO_INCREMENT,
                            id_usuario int(11) DEFAULT NULL,
                            id_actividad int(11) DEFAULT NULL,
                            descripcion varchar(255) DEFAULT NULL,
                            fecha datetime DEFAULT NULL,
                            PRIMARY KEY (id_comentario),
                            KEY id_usuario (id_usuario),
                            KEY id_actividad (id_actividad),
                            CONSTRAINT comentario_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario),
                            CONSTRAINT comentario_ibfk_2 FOREIGN KEY (id_actividad) REFERENCES ACTIVIDADES (id_actividad)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE COMENTARIOS_TICKET (
                                    id_comentario int(11) NOT NULL AUTO_INCREMENT,
                                    id_ticket int(11) DEFAULT NULL,
                                    comentario text DEFAULT NULL,
                                    fecha datetime DEFAULT NULL,
                                    PRIMARY KEY (id_comentario),
                                    KEY id_ticket (id_ticket),
                                    CONSTRAINT comentarios_ticket_ibfk_1 FOREIGN KEY (id_ticket) REFERENCES TICKETS (id_ticket)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE DETALLE_PEDIDO (
                                id_detalle int(11) NOT NULL AUTO_INCREMENT,
                                id_pedido int(11) DEFAULT NULL,
                                id_producto int(11) DEFAULT NULL,
                                cantidad int(11) DEFAULT NULL,
                                precio_unitario decimal(10,2) DEFAULT NULL,
                                descuento decimal(10,2) DEFAULT NULL,
                                subtotal decimal(10,2) DEFAULT NULL,
                                PRIMARY KEY (id_detalle),
                                KEY id_pedido (id_pedido),
                                KEY id_producto (id_producto),
                                CONSTRAINT detalle_pedido_ibfk_1 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido),
                                CONSTRAINT detalle_pedido_ibfk_2 FOREIGN KEY (id_producto) REFERENCES PRODUCTO (id_producto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE FACTURAS (
                          id_factura int(11) NOT NULL AUTO_INCREMENT,
                          id_usuario int(11) DEFAULT NULL,
                          id_cliente int(11) DEFAULT NULL,
                          id_pedido int(11) DEFAULT NULL,
                          precio_total decimal(10,2) DEFAULT NULL,
                          descripcion text DEFAULT NULL,
                          estado varchar(50) DEFAULT NULL,
                          PRIMARY KEY (id_factura),
                          KEY id_usuario (id_usuario),
                          KEY id_cliente (id_cliente),
                          KEY id_pedido (id_pedido),
                          CONSTRAINT facturas_ibfk_1 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario),
                          CONSTRAINT facturas_ibfk_2 FOREIGN KEY (id_cliente) REFERENCES CLIENTES (id_cliente),
                          CONSTRAINT facturas_ibfk_3 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE HISTORIAL_ACTIVIDADES (
                                       id_actividad_h int(11) NOT NULL AUTO_INCREMENT,
                                       id_actividad int(11) DEFAULT NULL,
                                       fecha date DEFAULT NULL,
                                       resultado text DEFAULT NULL,
                                       PRIMARY KEY (id_actividad_h),
                                       KEY id_actividad (id_actividad),
                                       CONSTRAINT historial_actividades_ibfk_1 FOREIGN KEY (id_actividad) REFERENCES ACTIVIDADES (id_actividad)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE HISTORIAL_TICKET (
                                  id_historial int(11) NOT NULL AUTO_INCREMENT,
                                  id_ticket int(11) DEFAULT NULL,
                                  id_usuario int(11) DEFAULT NULL,
                                  id_comentario int(11) DEFAULT NULL,
                                  fecha datetime DEFAULT NULL,
                                  PRIMARY KEY (id_historial),
                                  KEY id_ticket (id_ticket),
                                  KEY id_usuario (id_usuario),
                                  KEY id_comentario (id_comentario),
                                  CONSTRAINT historial_ticket_ibfk_1 FOREIGN KEY (id_ticket) REFERENCES TICKETS (id_ticket),
                                  CONSTRAINT historial_ticket_ibfk_2 FOREIGN KEY (id_usuario) REFERENCES USUARIOS_ERP (id_usuario),
                                  CONSTRAINT historial_ticket_ibfk_3 FOREIGN KEY (id_comentario) REFERENCES COMENTARIOS_TICKET (id_comentario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE LINEA_FACTURA (
                               id_linea int(11) NOT NULL AUTO_INCREMENT,
                               id_factura int(11) DEFAULT NULL,
                               id_pedido int(11) DEFAULT NULL,
                               id_producto int(11) DEFAULT NULL,
                               id_impuesto int(11) DEFAULT NULL,
                               id_gasto int(11) DEFAULT NULL,
                               cantidad int(11) DEFAULT NULL,
                               precio_unitario decimal(10,2) DEFAULT NULL,
                               descripcion text DEFAULT NULL,
                               PRIMARY KEY (id_linea),
                               KEY id_factura (id_factura),
                               KEY id_pedido (id_pedido),
                               KEY id_producto (id_producto),
                               KEY id_impuesto (id_impuesto),
                               KEY id_gasto (id_gasto),
                               CONSTRAINT linea_factura_ibfk_1 FOREIGN KEY (id_factura) REFERENCES FACTURAS (id_factura),
                               CONSTRAINT linea_factura_ibfk_2 FOREIGN KEY (id_pedido) REFERENCES PEDIDO (id_pedido),
                               CONSTRAINT linea_factura_ibfk_3 FOREIGN KEY (id_producto) REFERENCES PRODUCTO (id_producto),
                               CONSTRAINT linea_factura_ibfk_4 FOREIGN KEY (id_impuesto) REFERENCES IMPUESTO (id_impuesto),
                               CONSTRAINT linea_factura_ibfk_5 FOREIGN KEY (id_gasto) REFERENCES GASTO (id_gasto)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PAGOS_GASTOS (
                              id_pago_gasto int(11) NOT NULL AUTO_INCREMENT,
                              id_gasto int(11) DEFAULT NULL,
                              id_movimiento int(11) DEFAULT NULL,
                              PRIMARY KEY (id_pago_gasto),
                              KEY id_gasto (id_gasto),
                              KEY id_movimiento (id_movimiento),
                              CONSTRAINT pagos_gastos_ibfk_1 FOREIGN KEY (id_gasto) REFERENCES GASTO (id_gasto),
                              CONSTRAINT pagos_gastos_ibfk_2 FOREIGN KEY (id_movimiento) REFERENCES MOVIMIENTOS_BANCARIOS (id_movimiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE PAGOS_NOMINA (
                              id_pago_nomina int(11) NOT NULL AUTO_INCREMENT,
                              id_nomina int(11) DEFAULT NULL,
                              id_movimiento int(11) DEFAULT NULL,
                              fecha_transferencia datetime DEFAULT NULL,
                              PRIMARY KEY (id_pago_nomina),
                              KEY id_nomina (id_nomina),
                              KEY id_movimiento (id_movimiento),
                              CONSTRAINT pagos_nomina_ibfk_1 FOREIGN KEY (id_nomina) REFERENCES NOMINA (id_nomina),
                              CONSTRAINT pagos_nomina_ibfk_2 FOREIGN KEY (id_movimiento) REFERENCES MOVIMIENTOS_BANCARIOS (id_movimiento)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;