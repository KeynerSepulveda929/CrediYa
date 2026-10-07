/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.dao;

import com.mycompany.crediya.model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // INSERTAR
    public boolean guardar(Empleado empleado) {

        String sql = """
                INSERT INTO empleados
                (nombre, documento, rol, correo, salario)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getDocumento());
            ps.setString(3, empleado.getRol());
            ps.setString(4, empleado.getCorreo());
            ps.setDouble(5, empleado.getSalario());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al guardar empleado:");
            System.out.println(e.getMessage());

            return false;
        }
    }

    // LISTAR
    public List<Empleado> listar() {

        List<Empleado> empleados = new ArrayList<>();

        String sql = "SELECT * FROM empleados";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Empleado empleado = new Empleado();

                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDocumento(rs.getString("documento"));
                empleado.setRol(rs.getString("rol"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setSalario(rs.getDouble("salario"));

                empleados.add(empleado);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar empleados:");
            System.out.println(e.getMessage());
        }

        return empleados;
    }

    // BUSCAR POR ID
    public Empleado buscarPorId(int id) {

        String sql = "SELECT * FROM empleados WHERE id = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Empleado empleado = new Empleado();

                    empleado.setId(rs.getInt("id"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setDocumento(rs.getString("documento"));
                    empleado.setRol(rs.getString("rol"));
                    empleado.setCorreo(rs.getString("correo"));
                    empleado.setSalario(rs.getDouble("salario"));

                    return empleado;
                }
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar empleado:");
            System.out.println(e.getMessage());
        }

        return null;
    }
}