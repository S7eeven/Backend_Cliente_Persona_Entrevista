# Proyecto Spring Boot - Entrevista Técnica - Microservicio Cliente, Persona.

## Descripción del Proyecto

Este proyecto es una aplicación desarrollada en Java utilizando Spring Boot, diseñada para gestionar clientes y cuentas bancarias. Incluye la gestión de movimientos, clientes y personas asociadas a cada cliente.

## Funcionalidades del API.
- F1: Generación de CRUDS (Crear, editar, actualizar y eliminar registros - Entidades: Cliente,
Cuenta y Movimiento).
Los nombres de los endpoints a generar son:
• /cuentas
• /clientes
• /movimientos

- F2: Registro de movimientos: al registrar un movimiento en la cuenta se debe tener en cuenta
lo siguiente:
• Para un movimiento se pueden tener valores positivos o negativos.
• Al realizar un movimiento se debe actualizar el saldo disponible.
• Se debe llevar el registro de las transacciones realizadas

- F3: Registro de movimientos: Al realizar un movimiento el cual no cuente con saldo, debe
alertar mediante el siguiente mensaje “Saldo no disponible”
• Defina, según su expertise, la mejor manera de capturar y mostrar el error.

- F4: Reportes: Generar un reporte de “Estado de cuenta” especificando un rango de fechas y
cliente.
• Este reporte debe contener:
o Cuentas asociadas con sus respectivos saldos
o Detalle de movimientos de las cuentas
• EL endpoint de que sebe utilizar para esto debe ser el siguiente:
o (/reportes?fecha=rango fechas)
• El servicio del reporte debe retornar la información en formato JSON
o Defina, según su expertise, la mejor manera de solicitar y retornar esta
información.

- F5: Pruebas unitarias: Implementar 1 prueba unitaria para la entidad de dominio Cliente.


## Requisitos Previos

- JDK 17
- Maven
- IDE ( VS CODE, IntelliJ, etc.)
- BD MySQL(XAMPP)


## Configuración del Proyecto

1. Clona este repositorio:

   git clone
   cd nombre_del_repositorio



## Ejecuta la aplicación.

- ./mvnw spring-boot:run

## Las Rutas de Postman se encuentran.
- Rutas en archivo: nttDataEntrevistaRUTAS.postman_collection