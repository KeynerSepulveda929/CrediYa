/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/crediya_db";

    private static final String USER =
            System.getenv("CREDIYA_DB_USER");

    private static final String PASSWORD =
            System.getenv("CREDIYA_DB_PASSWORD");

    public static Connection conectar() {

        try {

            if (USER == null || PASSWORD == null) {
                throw new SQLException(
                    "No se encontraron las variables CREDIYA_DB_USER " +
                    "y CREDIYA_DB_PASSWORD."
                );
            }

            Connection conexion = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Conexion exitosa a MySQL.");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL:");
            System.out.println(e.getMessage());

            return null;
        }
    }
}