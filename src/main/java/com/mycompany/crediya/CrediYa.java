/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//
package com.mycompany.crediya;

import com.mycompany.crediya.model.Empleado;
import com.mycompany.crediya.service.EmpleadoService;

import java.util.Scanner;

public class CrediYa {

    private static final Scanner scanner = new Scanner(System.in);

    private static final EmpleadoService empleadoService =
            new EmpleadoService();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

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
                    System.out.println();
                    System.out.println(
                            "Gracias por utilizar CrediYa."
                    );
                    break;

                default:
                    System.out.println();
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);

        scanner.close();
    }

    // =====================================================
    // MENÚ PRINCIPAL
    // =====================================================

    private static void mostrarMenu() {

        System.out.println();
        System.out.println("====================================");
        System.out.println("          CREDIYA S.A.S.");
        System.out.println("====================================");
        System.out.println("1. Gestión de empleados");
        System.out.println("2. Gestión de clientes");
        System.out.println("3. Gestión de préstamos");
        System.out.println("4. Gestión de pagos");
        System.out.println("5. Reportes");
        System.out.println("6. Archivos");
        System.out.println("0. Salir");
        System.out.println("====================================");
    }

    // =====================================================
    // MENÚ EMPLEADOS
    // =====================================================

    private static void menuEmpleados() {

        int opcion;

        do {

            System.out.println();
            System.out.println("===== EMPLEADOS =====");
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
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // =====================================================
    // REGISTRAR EMPLEADO
    // =====================================================

    private static void registrarEmpleado() {

        System.out.println();
        System.out.println("===== REGISTRAR EMPLEADO =====");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Rol: ");
        String rol = scanner.nextLine();

        System.out.print("Correo: ");
        String correo = scanner.nextLine();

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

            System.out.println();
            System.out.println(
                    "Empleado registrado correctamente."
            );

        } else {

            System.out.println();
            System.out.println(
                    "No se pudo registrar el empleado."
            );
        }
    }

    // =====================================================
    // LISTAR EMPLEADOS
    // =====================================================

    private static void listarEmpleados() {

        System.out.println();
        System.out.println("===== LISTA DE EMPLEADOS =====");

        var empleados = empleadoService.listarEmpleados();

        if (empleados.isEmpty()) {

            System.out.println(
                    "No hay empleados registrados."
            );

            return;
        }

        empleados.forEach(System.out::println);
    }

    // =====================================================
    // BUSCAR EMPLEADO
    // =====================================================

    private static void buscarEmpleado() {

        System.out.println();
        System.out.println("===== BUSCAR EMPLEADO =====");

        int id = leerEntero(
                "ID del empleado: "
        );

        Empleado empleado =
                empleadoService.buscarEmpleado(id);

        if (empleado == null) {

            System.out.println(
                    "No se encontró el empleado."
            );

            return;
        }

        System.out.println();
        System.out.println("Empleado encontrado:");
        System.out.println(empleado);
    }

    // =====================================================
    // MENÚ CLIENTES
    // =====================================================

    private static void menuClientes() {

        int opcion;

        do {

            System.out.println();
            System.out.println("===== CLIENTES =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Consultar préstamos de cliente");
            System.out.println("0. Volver");

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    System.out.println(
                            "Registrar cliente - próximamente"
                    );
                    break;

                case 2:
                    System.out.println(
                            "Listar clientes - próximamente"
                    );
                    break;

                case 3:
                    System.out.println(
                            "Buscar cliente - próximamente"
                    );
                    break;

                case 4:
                    System.out.println(
                            "Consultar préstamos - próximamente"
                    );
                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // =====================================================
    // MENÚ PRÉSTAMOS
    // =====================================================

    private static void menuPrestamos() {

        int opcion;

        do {

            System.out.println();
            System.out.println("===== PRÉSTAMOS =====");
            System.out.println("1. Crear préstamo");
            System.out.println("2. Listar préstamos");
            System.out.println("3. Consultar préstamo");
            System.out.println("0. Volver");

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    System.out.println(
                            "Crear préstamo - próximamente"
                    );
                    break;

                case 2:
                    System.out.println(
                            "Listar préstamos - próximamente"
                    );
                    break;

                case 3:
                    System.out.println(
                            "Consultar préstamo - próximamente"
                    );
                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // =====================================================
    // MENÚ PAGOS
    // =====================================================

    private static void menuPagos() {

        int opcion;

        do {

            System.out.println();
            System.out.println("===== PAGOS =====");
            System.out.println("1. Registrar abono");
            System.out.println("2. Ver historial de pagos");
            System.out.println("0. Volver");

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    System.out.println(
                            "Registrar abono - próximamente"
                    );
                    break;

                case 2:
                    System.out.println(
                            "Historial de pagos - próximamente"
                    );
                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // =====================================================
    // MENÚ REPORTES
    // =====================================================

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

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                    System.out.println(
                            "Préstamos activos - próximamente"
                    );
                    break;

                case 2:
                    System.out.println(
                            "Préstamos pagados - próximamente"
                    );
                    break;

                case 3:
                    System.out.println(
                            "Clientes morosos - próximamente"
                    );
                    break;

                case 4:
                    System.out.println(
                            "Resumen de cartera - próximamente"
                    );
                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // =====================================================
    // MENÚ ARCHIVOS
    // =====================================================

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

            opcion = leerEntero(
                    "Seleccione una opción: "
            );

            switch (opcion) {

                case 1:
                case 2:
                case 3:
                case 4:

                    System.out.println(
                            "Exportación - próximamente"
                    );

                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 0);
    }

    // =====================================================
    // LEER ENTERO
    // =====================================================

    private static int leerEntero(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Debe ingresar un número válido."
                );
            }
        }
    }

    // =====================================================
    // LEER DOUBLE
    // =====================================================

    private static double leerDouble(String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Double.parseDouble(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Debe ingresar un número válido."
                );
            }
        }
    }
}