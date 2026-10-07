/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.dao;

import com.mycompany.crediya.model.Pago;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {

    public boolean registrarPago(Pago pago) {

        String insertarPago = """
                INSERT INTO pagos
                (prestamo_id, fecha_pago, monto)
                VALUES (?, ?, ?)
                """;

        String actualizarPrestamo = """
                UPDATE prestamos
                SET saldo_pendiente = saldo_pendiente - ?,
                    estado = CASE
                        WHEN saldo_pendiente - ? <= 0
                        THEN 'PAGADO'
                        ELSE 'PENDIENTE'
                    END
                WHERE id = ?
                """;

        Connection conexion = null;

        try {

            conexion = Conexion.conectar();

            if (conexion == null) {
                return false;
            }

            // Iniciamos la transacción
            conexion.setAutoCommit(false);

            // 1. Registrar el pago
            try (PreparedStatement psPago =
                         conexion.prepareStatement(insertarPago)) {

                psPago.setInt(
                        1,
                        pago.getPrestamo().getId()
                );

                psPago.setDate(
                        2,
                        Date.valueOf(pago.getFechaPago())
                );

                psPago.setDouble(
                        3,
                        pago.getMonto()
                );

                psPago.executeUpdate();
            }

            // 2. Actualizar el préstamo
            try (PreparedStatement psPrestamo =
                         conexion.prepareStatement(actualizarPrestamo)) {

                psPrestamo.setDouble(
                        1,
                        pago.getMonto()
                );

                psPrestamo.setDouble(
                        2,
                        pago.getMonto()
                );

                psPrestamo.setInt(
                        3,
                        pago.getPrestamo().getId()
                );

                int filas = psPrestamo.executeUpdate();

                if (filas == 0) {
                    throw new SQLException(
                            "No se encontró el préstamo."
                    );
                }
            }

            // Confirmamos ambas operaciones
            conexion.commit();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al registrar pago:");
            System.out.println(e.getMessage());

            if (conexion != null) {
                try {
                    conexion.rollback();
                    System.out.println(
                            "Se revirtieron los cambios."
                    );
                } catch (SQLException ex) {
                    System.out.println(
                            "No se pudo hacer rollback."
                    );
                }
            }

            return false;

        } finally {

            if (conexion != null) {
                try {
                    conexion.setAutoCommit(true);
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println(
                            "Error al cerrar conexión."
                    );
                }
            }
        }
    }

    public List<Pago> listarPorPrestamo(int prestamoId) {

        List<Pago> pagos = new ArrayList<>();

        String sql = """
                SELECT id, prestamo_id, fecha_pago, monto
                FROM pagos
                WHERE prestamo_id = ?
                ORDER BY fecha_pago
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps =
                     conexion.prepareStatement(sql)) {

            ps.setInt(1, prestamoId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Pago pago = new Pago();

                    pago.setId(
                            rs.getInt("id")
                    );

                    pago.setFechaPago(
                            rs.getDate("fecha_pago")
                                    .toLocalDate()
                    );

                    pago.setMonto(
                            rs.getDouble("monto")
                    );

                    pagos.add(pago);
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al consultar pagos:"
            );

            System.out.println(e.getMessage());
        }

        return pagos;
    }
}
