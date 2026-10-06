/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.model;

import java.time.LocalDate;

public class Pago {

    private int id;
    private Prestamo prestamo;
    private LocalDate fechaPago;
    private double monto;

    public Pago() {
    }

    public Pago(int id, Prestamo prestamo,
                LocalDate fechaPago, double monto) {

        this.id = id;
        this.prestamo = prestamo;
        this.fechaPago = fechaPago;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {

        return "Pago #"
                + id
                + " | Prestamo: #"
                + prestamo.getId()
                + " | Fecha: "
                + fechaPago
                + " | Monto: $"
                + monto;
    }
}
