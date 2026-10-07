/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.dao;

import com.mycompany.crediya.model.Cliente;
import com.mycompany.crediya.model.Empleado;
import com.mycompany.crediya.model.Prestamo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public boolean guardar(Prestamo prestamo) {

        String sql = """
                INSERT INTO prestamos
                (
                    cliente_id,
                    empleado_id,
                    monto,
                    interes,
                    cuotas,
                    fecha_inicio,
                    estado,
                    total_pagar,
                    cuota_mensual,
                    saldo_pendiente
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getCliente().getId());
            ps.setInt(2, prestamo.getEmpleado().getId());
            ps.setDouble(3, prestamo.getMonto());
            ps.setDouble(4, prestamo.getInteres());
            ps.setInt(5, prestamo.getCuotas());
            ps.setDate(
                    6,
                    Date.valueOf(prestamo.getFechaInicio())
            );
            ps.setString(7, prestamo.getEstado());
            ps.setDouble(8, prestamo.getTotalPagar());
            ps.setDouble(9, prestamo.getCuotaMensual());
            ps.setDouble(10, prestamo.getSaldoPendiente());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al guardar préstamo:");
            System.out.println(e.getMessage());

            return false;
        }
    }

    public List<Prestamo> listar() {

        List<Prestamo> prestamos = new ArrayList<>();

        String sql = """
                SELECT
                    p.*,

                    c.nombre AS cliente_nombre,
                    c.documento AS cliente_documento,
                    c.correo AS cliente_correo,
                    c.telefono AS cliente_telefono,

                    e.nombre AS empleado_nombre,
                    e.documento AS empleado_documento,
                    e.correo AS empleado_correo,
                    e.rol AS empleado_rol,
                    e.salario AS empleado_salario

                FROM prestamos p

                INNER JOIN clientes c
                    ON p.cliente_id = c.id

                INNER JOIN empleados e
                    ON p.empleado_id = e.id
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("cliente_nombre"),
                        rs.getString("cliente_documento"),
                        rs.getString("cliente_correo"),
                        rs.getString("cliente_telefono")
                );

                Empleado empleado = new Empleado(
                        rs.getInt("empleado_id"),
                        rs.getString("empleado_nombre"),
                        rs.getString("empleado_documento"),
                        rs.getString("empleado_correo"),
                        rs.getString("empleado_rol"),
                        rs.getDouble("empleado_salario")
                );

                Prestamo prestamo = new Prestamo();

                prestamo.setId(rs.getInt("id"));
                prestamo.setCliente(cliente);
                prestamo.setEmpleado(empleado);
                prestamo.setMonto(rs.getDouble("monto"));
                prestamo.setInteres(rs.getDouble("interes"));
                prestamo.setCuotas(rs.getInt("cuotas"));

                Date fecha = rs.getDate("fecha_inicio");

                if (fecha != null) {
                    prestamo.setFechaInicio(
                            fecha.toLocalDate()
                    );
                }

                prestamo.setEstado(
                        rs.getString("estado")
                );
                
                prestamo.setTotalPagar(
                    rs.getDouble("total_pagar")
                );

                prestamo.setCuotaMensual(
                    rs.getDouble("cuota_mensual")
                );

                prestamo.setSaldoPendiente(
                    rs.getDouble("saldo_pendiente")
                );

                prestamos.add(prestamo);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar préstamos:");
            System.out.println(e.getMessage());
        }

        return prestamos;
    }
    
    public Prestamo buscarPorId(int id) {

    String sql = """
            SELECT
                p.*,

                c.nombre AS cliente_nombre,
                c.documento AS cliente_documento,
                c.correo AS cliente_correo,
                c.telefono AS cliente_telefono,

                e.nombre AS empleado_nombre,
                e.documento AS empleado_documento,
                e.correo AS empleado_correo,
                e.rol AS empleado_rol,
                e.salario AS empleado_salario

            FROM prestamos p

            INNER JOIN clientes c
                ON p.cliente_id = c.id

            INNER JOIN empleados e
                ON p.empleado_id = e.id

            WHERE p.id = ?
            """;

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps =
                 conexion.prepareStatement(sql)) {

        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("cliente_nombre"),
                        rs.getString("cliente_documento"),
                        rs.getString("cliente_correo"),
                        rs.getString("cliente_telefono")
                );

                Empleado empleado = new Empleado(
                        rs.getInt("empleado_id"),
                        rs.getString("empleado_nombre"),
                        rs.getString("empleado_documento"),
                        rs.getString("empleado_correo"),
                        rs.getString("empleado_rol"),
                        rs.getDouble("empleado_salario")
                );

                Prestamo prestamo = new Prestamo();

                prestamo.setId(rs.getInt("id"));
                prestamo.setCliente(cliente);
                prestamo.setEmpleado(empleado);
                prestamo.setMonto(rs.getDouble("monto"));
                prestamo.setInteres(rs.getDouble("interes"));
                prestamo.setCuotas(rs.getInt("cuotas"));

                Date fecha = rs.getDate("fecha_inicio");

                if (fecha != null) {
                    prestamo.setFechaInicio(
                            fecha.toLocalDate()
                    );
                }

                prestamo.setEstado(
                        rs.getString("estado")
                );

                prestamo.setTotalPagar(
                        rs.getDouble("total_pagar")
                );

                prestamo.setCuotaMensual(
                        rs.getDouble("cuota_mensual")
                );

                prestamo.setSaldoPendiente(
                        rs.getDouble("saldo_pendiente")
                );

                return prestamo;
            }
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar préstamo:"
        );

        System.out.println(e.getMessage());
    }

    return null;
}
}
