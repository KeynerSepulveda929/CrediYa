/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.service;

import com.mycompany.crediya.dao.PagoDAO;
import com.mycompany.crediya.model.Pago;

import java.util.List;

public class PagoService {

    private final PagoDAO pagoDAO;

    public PagoService() {
        this.pagoDAO = new PagoDAO();
    }

    public boolean registrarPago(Pago pago) {

        if (pago == null) {
            System.out.println("El pago no puede ser nulo.");
            return false;
        }

        if (pago.getPrestamo() == null) {
            System.out.println(
                    "El pago debe estar asociado a un préstamo."
            );
            return false;
        }

        if (pago.getMonto() <= 0) {
            System.out.println(
                    "El monto debe ser mayor que cero."
            );
            return false;
        }

        if (pago.getMonto() >
                pago.getPrestamo().getSaldoPendiente()) {

            System.out.println(
                    "El pago supera el saldo pendiente."
            );

            return false;
        }

        return pagoDAO.registrarPago(pago);
    }

    public List<Pago> consultarPagos(int prestamoId) {
        return pagoDAO.listarPorPrestamo(prestamoId);
    }
}
