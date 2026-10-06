/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//package com.mycompany.crediya;
//
//import com.mycompany.crediya.dao.Conexion;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class CrediYa {
//
//    public static void main(String[] args) {
//
//        Connection conexion = Conexion.conectar();
//
//        if (conexion != null) {
//
//            System.out.println("-----------------------------");
//            System.out.println("       CREDIYA S.A.S.");
//            System.out.println("-----------------------------");
//            System.out.println("Sistema iniciado correctamente.");
//
//            try {
//
//                conexion.close();
//
//                System.out.println("Conexion cerrada.");
//
//            } catch (SQLException e) {
//
//                System.out.println("Error al cerrar conexion.");
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//}

//package com.mycompany.crediya;
//
//import com.mycompany.crediya.model.Cliente;
//import com.mycompany.crediya.model.Empleado;
//import com.mycompany.crediya.model.Persona;
//
//public class CrediYa {
//
//    public static void main(String[] args) {
//
//        Empleado empleado = new Empleado(
//                1,
//                "Carlos Perez",
//                "123456789",
//                "carlos@crediya.com",
//                "Asesor de credito",
//                2500000
//        );
//
//        Cliente cliente = new Cliente(
//                1,
//                "Maria Gomez",
//                "987654321",
//                "maria@gmail.com",
//                "3001234567"
//        );
//
//        System.out.println("===== EMPLEADO =====");
//        System.out.println(empleado);
//
//        System.out.println();
//
//        System.out.println("===== CLIENTE =====");
//        System.out.println(cliente);
//
//        System.out.println();
//
//        Persona persona1 = empleado;
//        Persona persona2 = cliente;
//
//        System.out.println("===== POLIMORFISMO =====");
//
//        System.out.println(persona1.getTipoPersona());
//        System.out.println(persona2.getTipoPersona());
//    }
//}

package com.mycompany.crediya;

import com.mycompany.crediya.model.Cliente;
import com.mycompany.crediya.model.Empleado;
import com.mycompany.crediya.model.Prestamo;
import java.time.LocalDate;

public class CrediYa {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(
                1,
                "Maria Gomez",
                "987654321",
                "maria@gmail.com",
                "3001234567"
        );

        Empleado empleado = new Empleado(
                1,
                "Carlos Perez",
                "123456789",
                "carlos@crediya.com",
                "Asesor",
                2500000
        );

        Prestamo prestamo = new Prestamo(
                1,
                cliente,
                empleado,
                1000000,
                10,
                11,
                LocalDate.now()
        );

        System.out.println("===== PRESTAMO =====");
        System.out.println(prestamo);

        System.out.println();
        System.out.println("===== REGISTRANDO PAGO =====");

        prestamo.registrarPago(100000);

        System.out.println(prestamo);
    }
}