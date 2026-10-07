/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.service;

import com.mycompany.crediya.dao.PrestamoDAO;
import com.mycompany.crediya.model.Prestamo;

import java.util.List;

public class PrestamoService {

    private final PrestamoDAO prestamoDAO;

    public PrestamoService() {
        this.prestamoDAO = new PrestamoDAO();
    }

    public boolean registrarPrestamo(Prestamo prestamo) {

        if (prestamo.getCliente() == null) {
            System.out.println("Debe seleccionar un cliente.");
            return false;
        }

        if (prestamo.getEmpleado() == null) {
            System.out.println("Debe seleccionar un empleado.");
            return false;
        }

        if (prestamo.getMonto() <= 0) {
            System.out.println("El monto debe ser mayor que cero.");
            return false;
        }

        if (prestamo.getInteres() < 0) {
            System.out.println("El interés no puede ser negativo.");
            return false;
        }

        if (prestamo.getCuotas() <= 0) {
            System.out.println("Las cuotas deben ser mayores que cero.");
            return false;
        }

        prestamo.calcularPrestamo();

        return prestamoDAO.guardar(prestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoDAO.listar();
    }
    
    public Prestamo buscarPrestamo(int id) {
        return prestamoDAO.buscarPorId(id);
    }
}
