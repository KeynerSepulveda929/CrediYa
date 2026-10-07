/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.service;

import com.mycompany.crediya.dao.EmpleadoDAO;
import com.mycompany.crediya.model.Empleado;
import java.util.List;

public class EmpleadoService {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoService() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public boolean registrarEmpleado(Empleado empleado) {

        if (empleado.getNombre() == null ||
            empleado.getNombre().isBlank()) {

            System.out.println("El nombre es obligatorio.");
            return false;
        }

        if (empleado.getDocumento() == null ||
            empleado.getDocumento().isBlank()) {

            System.out.println("El documento es obligatorio.");
            return false;
        }

        if (empleado.getSalario() < 0) {

            System.out.println("El salario no puede ser negativo.");
            return false;
        }

        return empleadoDAO.guardar(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return empleadoDAO.listar();
    }

    public Empleado buscarEmpleado(int id) {
        return empleadoDAO.buscarPorId(id);
    }
}