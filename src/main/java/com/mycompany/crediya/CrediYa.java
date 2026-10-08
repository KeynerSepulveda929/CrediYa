/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//
package com.mycompany.crediya;

import com.mycompany.crediya.model.Cliente;
import com.mycompany.crediya.model.Empleado;
import com.mycompany.crediya.model.Pago;
import com.mycompany.crediya.model.Prestamo;
import com.mycompany.crediya.service.ClienteService;
import com.mycompany.crediya.service.EmpleadoService;
import com.mycompany.crediya.service.PagoService;
import com.mycompany.crediya.service.PrestamoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CrediYa {

    private static final Scanner scanner = new Scanner(System.in);

    private static final EmpleadoService empleadoService = new EmpleadoService();
    private static final ClienteService clienteService = new ClienteService();
    private static final PrestamoService prestamoService = new PrestamoService();
    private static final PagoService pagoService = new PagoService();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println();
            System.out.println("======================================");
            System.out.println("          CREDIYA S.A.S.");
            System.out.println("======================================");
            System.out.println("1. Gestión de empleados");
            System.out.println("2. Gestión de clientes");
            System.out.println("3. Gestión de préstamos");
            System.out.println("4. Gestión de pagos");
            System.out.println("5. Reportes");
            System.out.println("6. Archivos");
            System.out.println("0. Salir");
            System.out.println("======================================");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    menuEmpleados();
                    break;

                case 2:
                    menuClientes();
                    break;

                case 3:
                    menuPrestamos();
                    break;

                case 4:
                    menuPagos();
                    break;

                case 5:
                    menuReportes();
                    break;

                case 6:
                    menuArchivos();
                    break;

                case 0:
                    System.out.println("Gracias por utilizar CrediYa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // ==========================================================
    // EMPLEADOS
    // ==========================================================

    private static void menuEmpleados() {

        int opcion;

        do {
            System.out.println();
            System.out.println("===== GESTIÓN DE EMPLEADOS =====");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar empleado");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarEmpleado();
                    break;

                case 2:
                    listarEmpleados();
                    break;

                case 3:
                    buscarEmpleado();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void registrarEmpleado() {

        System.out.println();
        System.out.println("===== REGISTRAR EMPLEADO =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Rol: ");
        String rol = scanner.nextLine();

        double salario = leerDouble("Salario: ");

        Empleado empleado = new Empleado(
                0,
                nombre,
                documento,
                correo,
                rol,
                salario
        );

        if (empleadoService.registrarEmpleado(empleado)) {
            System.out.println("Empleado registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el empleado.");
        }
    }

    private static void listarEmpleados() {

        System.out.println();
        System.out.println("===== LISTA DE EMPLEADOS =====");

        List<Empleado> empleados = empleadoService.listarEmpleados();

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    private static void buscarEmpleado() {

        System.out.println();
        System.out.println("===== BUSCAR EMPLEADO =====");

        int id = leerEntero("ID del empleado: ");

        Empleado empleado = empleadoService.buscarEmpleado(id);

        if (empleado == null) {
            System.out.println("No se encontró el empleado.");
        } else {
            System.out.println(empleado);
        }
    }

    // ==========================================================
    // CLIENTES
    // ==========================================================

    private static void menuClientes() {

        int opcion;

        do {
            System.out.println();
            System.out.println("===== GESTIÓN DE CLIENTES =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Consultar préstamos del cliente");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    buscarCliente();
                    break;

                case 4:
                    consultarPrestamosCliente();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void registrarCliente() {

        System.out.println();
        System.out.println("===== REGISTRAR CLIENTE =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        Cliente cliente = new Cliente(
                0,
                nombre,
                documento,
                correo,
                telefono
        );

        if (clienteService.registrarCliente(cliente)) {
            System.out.println("Cliente registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el cliente.");
        }
    }

    private static void listarClientes() {

        System.out.println();
        System.out.println("===== LISTA DE CLIENTES =====");

        List<Cliente> clientes = clienteService.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private static void buscarCliente() {

        System.out.println();
        System.out.println("===== BUSCAR CLIENTE =====");

        int id = leerEntero("ID del cliente: ");

        Cliente cliente = clienteService.buscarCliente(id);

        if (cliente == null) {
            System.out.println("No se encontró el cliente.");
        } else {
            System.out.println(cliente);
        }
    }

    private static void consultarPrestamosCliente() {

        System.out.println();
        System.out.println("===== PRÉSTAMOS DEL CLIENTE =====");

        int clienteId = leerEntero("ID del cliente: ");

        Cliente cliente = clienteService.buscarCliente(clienteId);

        if (cliente == null) {
            System.out.println("El cliente no existe.");
            return;
        }

        List<Prestamo> prestamos = prestamoService.listarPrestamos();

        boolean encontrado = false;

        for (Prestamo prestamo : prestamos) {

            if (prestamo.getCliente() != null
                    && prestamo.getCliente().getId() == clienteId) {

                System.out.println(prestamo);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El cliente no tiene préstamos registrados.");
        }
    }

    // ==========================================================
    // PRÉSTAMOS
    // ==========================================================

    private static void menuPrestamos() {

        int opcion;

        do {
            System.out.println();
            System.out.println("===== GESTIÓN DE PRÉSTAMOS =====");
            System.out.println("1. Crear préstamo");
            System.out.println("2. Listar préstamos");
            System.out.println("3. Consultar préstamo");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarPrestamo();
                    break;

                case 2:
                    listarPrestamos();
                    break;

                case 3:
                    buscarPrestamo();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void registrarPrestamo() {

        System.out.println();
        System.out.println("===== CREAR PRÉSTAMO =====");

        int clienteId = leerEntero("ID del cliente: ");

        Cliente cliente = clienteService.buscarCliente(clienteId);

        if (cliente == null) {
            System.out.println("El cliente no existe.");
            return;
        }

        int empleadoId = leerEntero("ID del empleado: ");

        Empleado empleado = empleadoService.buscarEmpleado(empleadoId);

        if (empleado == null) {
            System.out.println("El empleado no existe.");
            return;
        }

        double monto = leerDouble("Monto del préstamo: ");

        double interes = leerDouble("Interés (%): ");

        int cuotas = leerEntero("Número de cuotas: ");

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return;
        }

        if (interes < 0) {
            System.out.println("El interés no puede ser negativo.");
            return;
        }

        if (cuotas <= 0) {
            System.out.println("Las cuotas deben ser mayores que cero.");
            return;
        }

        Prestamo prestamo = new Prestamo(
                0,
                cliente,
                empleado,
                monto,
                interes,
                cuotas,
                LocalDate.now()
        );

        System.out.println();
        System.out.println("===== RESUMEN DEL PRÉSTAMO =====");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Empleado: " + empleado.getNombre());
        System.out.println("Monto: $" + prestamo.getMonto());
        System.out.println("Interés: " + prestamo.getInteres() + "%");
        System.out.println("Cuotas: " + prestamo.getCuotas());
        System.out.println("Total a pagar: $" + prestamo.getTotalPagar());
        System.out.println("Cuota mensual: $" + prestamo.getCuotaMensual());
        System.out.println("Saldo pendiente: $" + prestamo.getSaldoPendiente());

        if (prestamoService.registrarPrestamo(prestamo)) {
            System.out.println();
            System.out.println("Préstamo registrado correctamente.");
        } else {
            System.out.println();
            System.out.println("No se pudo registrar el préstamo.");
        }
    }

    private static void listarPrestamos() {

        System.out.println();
        System.out.println("===== LISTA DE PRÉSTAMOS =====");

        List<Prestamo> prestamos = prestamoService.listarPrestamos();

        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }

    private static void buscarPrestamo() {

        System.out.println();
        System.out.println("===== CONSULTAR PRÉSTAMO =====");

        int id = leerEntero("ID del préstamo: ");

        Prestamo prestamo = prestamoService.buscarPrestamo(id);

        if (prestamo == null) {
            System.out.println("No se encontró el préstamo.");
        } else {

            System.out.println();
            System.out.println("===== INFORMACIÓN DEL PRÉSTAMO =====");
            System.out.println(prestamo);
        }
    }

    // ==========================================================
    // PAGOS
    // ==========================================================

    private static void menuPagos() {

        int opcion;

        do {
            System.out.println();
            System.out.println("===== GESTIÓN DE PAGOS =====");
            System.out.println("1. Registrar pago");
            System.out.println("2. Ver historial de pagos");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    registrarPago();
                    break;

                case 2:
                    listarPagos();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void registrarPago() {

        System.out.println();
        System.out.println("===== REGISTRAR PAGO =====");

        int prestamoId = leerEntero("ID del préstamo: ");

        Prestamo prestamo = prestamoService.buscarPrestamo(prestamoId);

        if (prestamo == null) {
            System.out.println("El préstamo no existe.");
            return;
        }

        if ("PAGADO".equalsIgnoreCase(prestamo.getEstado())
                || prestamo.getSaldoPendiente() <= 0) {

            System.out.println("Este préstamo ya está completamente pagado.");
            return;
        }

        System.out.println("Saldo pendiente: $" + prestamo.getSaldoPendiente());

        double monto = leerDouble("Monto del pago: ");

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return;
        }

        if (monto > prestamo.getSaldoPendiente()) {
            System.out.println(
                    "El pago no puede ser mayor al saldo pendiente."
            );
            return;
        }

        Pago pago = new Pago(
                0,
                prestamo,
                LocalDate.now(),
                monto
        );

        if (pagoService.registrarPago(pago)) {

            System.out.println();
            System.out.println("Pago registrado correctamente.");

            Prestamo actualizado =
                    prestamoService.buscarPrestamo(prestamoId);

            if (actualizado != null) {

                System.out.println();
                System.out.println("===== ESTADO ACTUALIZADO =====");
                System.out.println(
                        "Saldo pendiente: $"
                        + actualizado.getSaldoPendiente()
                );
                System.out.println(
                        "Estado: "
                        + actualizado.getEstado()
                );
            }

        } else {
            System.out.println("No se pudo registrar el pago.");
        }
    }

    private static void listarPagos() {

        System.out.println();
        System.out.println("===== HISTORIAL DE PAGOS =====");

        int prestamoId = leerEntero("ID del préstamo: ");

        Prestamo prestamo = prestamoService.buscarPrestamo(prestamoId);

        if (prestamo == null) {
            System.out.println("El préstamo no existe.");
            return;
        }

        List<Pago> pagos = pagoService.consultarPagos(prestamoId);

        if (pagos.isEmpty()) {
            System.out.println("Este préstamo no tiene pagos registrados.");
            return;
        }

        System.out.println();
        System.out.println("Préstamo: " + prestamoId);

        for (Pago pago : pagos) {
            System.out.println(pago);
        }
    }

    // ==========================================================
    // REPORTES
    // ==========================================================

    private static void menuReportes() {

        int opcion;

        do {
            System.out.println();
            System.out.println("===== REPORTES =====");
            System.out.println("1. Préstamos activos");
            System.out.println("2. Préstamos pagados");
            System.out.println("3. Clientes morosos");
            System.out.println("4. Resumen de cartera");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    reportePrestamosActivos();
                    break;

                case 2:
                    reportePrestamosPagados();
                    break;

                case 3:
                    reporteClientesMorosos();
                    break;

                case 4:
                    reporteResumenCartera();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private static void reportePrestamosActivos() {

        System.out.println();
        System.out.println("===== PRÉSTAMOS ACTIVOS =====");

        List<Prestamo> prestamos = prestamoService.listarPrestamos();

        long cantidad = prestamos.stream()
                .filter(p -> "PENDIENTE".equalsIgnoreCase(p.getEstado()))
                .count();

        System.out.println("Cantidad de préstamos activos: " + cantidad);

        prestamos.stream()
                .filter(p -> "PENDIENTE".equalsIgnoreCase(p.getEstado()))
                .forEach(System.out::println);
    }

    private static void reportePrestamosPagados() {

        System.out.println();
        System.out.println("===== PRÉSTAMOS PAGADOS =====");

        List<Prestamo> prestamos = prestamoService.listarPrestamos();

        long cantidad = prestamos.stream()
                .filter(p -> "PAGADO".equalsIgnoreCase(p.getEstado()))
                .count();

        System.out.println("Cantidad de préstamos pagados: " + cantidad);

        prestamos.stream()
                .filter(p -> "PAGADO".equalsIgnoreCase(p.getEstado()))
                .forEach(System.out::println);
    }

    private static void reporteClientesMorosos() {

        System.out.println();
        System.out.println("===== CLIENTES CON SALDO PENDIENTE =====");

        List<Prestamo> prestamos = prestamoService.listarPrestamos();

        prestamos.stream()
                .filter(p -> p.getSaldoPendiente() > 0)
                .filter(p -> p.getCliente() != null)
                .map(p -> p.getCliente().getNombre())
                .distinct()
                .forEach(System.out::println);
    }

    private static void reporteResumenCartera() {

        System.out.println();
        System.out.println("===== RESUMEN DE CARTERA =====");

        List<Prestamo> prestamos = prestamoService.listarPrestamos();

        double totalPrestado = prestamos.stream()
                .mapToDouble(Prestamo::getMonto)
                .sum();

        double totalPendiente = prestamos.stream()
                .mapToDouble(Prestamo::getSaldoPendiente)
                .sum();

        double totalPagado = totalPrestado - totalPendiente;

        System.out.println("Total prestado: $" + totalPrestado);
        System.out.println("Total pagado: $" + totalPagado);
        System.out.println("Total pendiente: $" + totalPendiente);
        System.out.println("Cantidad de préstamos: " + prestamos.size());
    }

    // ==========================================================
    // ARCHIVOS
    // ==========================================================

    private static void menuArchivos() {

        int opcion;

        do {
            System.out.println();
            System.out.println("===== ARCHIVOS =====");
            System.out.println("1. Exportar empleados");
            System.out.println("2. Exportar clientes");
            System.out.println("3. Exportar préstamos");
            System.out.println("4. Exportar pagos");
            System.out.println("0. Volver");

            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {

                case 1:
                    System.out.println(
                            "Módulo de archivos pendiente de implementar."
                    );
                    break;

                case 2:
                    System.out.println(
                            "Módulo de archivos pendiente de implementar."
                    );
                    break;

                case 3:
                    System.out.println(
                            "Módulo de archivos pendiente de implementar."
                    );
                    break;

                case 4:
                    System.out.println(
                            "Módulo de archivos pendiente de implementar."
                    );
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // ==========================================================
    // MÉTODOS PARA LEER DATOS
    // ==========================================================

    private static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                int numero = Integer.parseInt(
                        scanner.nextLine()
                );

                return numero;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ingrese un número entero válido."
                );
            }
        }
    }

    private static double leerDouble(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                double numero = Double.parseDouble(
                        scanner.nextLine()
                );

                return numero;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Ingrese un número válido."
                );
            }
        }
    }
}