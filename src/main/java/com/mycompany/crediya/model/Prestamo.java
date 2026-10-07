/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.model;

import java.time.LocalDate;

public class Prestamo {

    private int id;
    private Cliente cliente;
    private Empleado empleado;
    private double monto;
    private double interes;
    private int cuotas;
    private LocalDate fechaInicio;
    private String estado;
    private double totalPagar;
    private double cuotaMensual;
    private double saldoPendiente;

    public Prestamo() {
    }

    public Prestamo(int id, Cliente cliente, Empleado empleado,
                    double monto, double interes, int cuotas,
                    LocalDate fechaInicio) {

        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.monto = monto;
        this.interes = interes;
        this.cuotas = cuotas;
        this.fechaInicio = fechaInicio;
        this.estado = "PENDIENTE";

        calcularPrestamo();
    }

    public void calcularPrestamo() {

        double valorInteres = monto * (interes / 100);

        totalPagar = monto + valorInteres;

        cuotaMensual = totalPagar / cuotas;

        saldoPendiente = totalPagar;
    }
    
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setCuotaMensual(double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public void registrarPago(double montoPago) {

        if (montoPago <= 0) {
            throw new IllegalArgumentException(
                    "El monto del pago debe ser mayor que cero."
            );
        }

        if (montoPago > saldoPendiente) {
            throw new IllegalArgumentException(
                    "El pago no puede superar el saldo pendiente."
            );
        }

        saldoPendiente -= montoPago;

        if (saldoPendiente == 0) {
            estado = "PAGADO";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public double getCuotaMensual() {
        return cuotaMensual;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    @Override
    public String toString() {

        return "Prestamo #"
                + id
                + " | Cliente: "
                + cliente.getNombre()
                + " | Monto: $"
                + monto
                + " | Interes: "
                + interes
                + "%"
                + " | Total: $"
                + totalPagar
                + " | Cuota: $"
                + cuotaMensual
                + " | Saldo: $"
                + saldoPendiente
                + " | Estado: "
                + estado;
    }
}
