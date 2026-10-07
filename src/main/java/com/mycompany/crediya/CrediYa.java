/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//
package com.mycompany.crediya;

import com.mycompany.crediya.model.Pago;
import com.mycompany.crediya.model.Prestamo;
import com.mycompany.crediya.service.PagoService;
import com.mycompany.crediya.service.PrestamoService;

import java.time.LocalDate;

public class CrediYa {

    public static void main(String[] args) {

        PrestamoService prestamoService =
                new PrestamoService();

        PagoService pagoService =
                new PagoService();

        // Buscar préstamo #1
        Prestamo prestamo =
                prestamoService.buscarPrestamo(1);

        if (prestamo == null) {

            System.out.println(
                    "No existe el préstamo #1."
            );

            return;
        }

        System.out.println("===== PRÉSTAMO =====");
        System.out.println(prestamo);

        // Crear pago
        Pago pago = new Pago(
                0,
                prestamo,
                LocalDate.now(),
                100000
        );

        // Registrar
        boolean registrado =
                pagoService.registrarPago(pago);

        if (registrado) {

            System.out.println();
            System.out.println(
                    "Pago registrado correctamente."
            );

        } else {

            System.out.println();
            System.out.println(
                    "No se pudo registrar el pago."
            );
        }
    }
}