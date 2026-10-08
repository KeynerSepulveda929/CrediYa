/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.dao;

import com.mycompany.crediya.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // ==========================================================
    // INSERTAR CLIENTE
    // ==========================================================

    public boolean insertar(Cliente cliente) {

        String sql = """
                INSERT INTO clientes
                (nombre, documento, correo, telefono)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDocumento());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error al registrar cliente: "
                    + e.getMessage()
            );

            return false;
        }
    }

    // ==========================================================
    // LISTAR CLIENTES
    // ==========================================================

    public List<Cliente> listarTodos() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = """
                SELECT id, nombre, documento, correo, telefono
                FROM clientes
                ORDER BY id
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("documento"),
                        rs.getString("correo"),
                        rs.getString("telefono")
                );

                clientes.add(cliente);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al listar clientes: "
                    + e.getMessage()
            );
        }

        return clientes;
    }

    // ==========================================================
    // BUSCAR CLIENTE POR ID
    // ==========================================================

    public Cliente buscarPorId(int id) {

        String sql = """
                SELECT id, nombre, documento, correo, telefono
                FROM clientes
                WHERE id = ?
                """;

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("documento"),
                            rs.getString("correo"),
                            rs.getString("telefono")
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al buscar cliente: "
                    + e.getMessage()
            );
        }

        return null;
    }
}
