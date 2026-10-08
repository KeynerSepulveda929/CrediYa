/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crediya.service;

import com.mycompany.crediya.dao.ClienteDAO;
import com.mycompany.crediya.model.Cliente;

import java.util.List;

public class ClienteService {

    private final ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    // Registrar cliente
    public boolean registrarCliente(Cliente cliente) {

        if (cliente == null) {
            System.out.println("El cliente no puede ser nulo.");
            return false;
        }

        if (cliente.getNombre() == null
                || cliente.getNombre().trim().isEmpty()) {

            System.out.println("El nombre del cliente es obligatorio.");
            return false;
        }

        if (cliente.getDocumento() == null
                || cliente.getDocumento().trim().isEmpty()) {

            System.out.println("El documento del cliente es obligatorio.");
            return false;
        }

        if (cliente.getCorreo() == null
                || cliente.getCorreo().trim().isEmpty()) {

            System.out.println("El correo del cliente es obligatorio.");
            return false;
        }

        if (cliente.getTelefono() == null
                || cliente.getTelefono().trim().isEmpty()) {

            System.out.println("El teléfono del cliente es obligatorio.");
            return false;
        }

        return clienteDAO.insertar(cliente);
    }

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
        return clienteDAO.listarTodos();
    }

    // Buscar cliente por ID
    public Cliente buscarCliente(int id) {

        if (id <= 0) {
            return null;
        }

        return clienteDAO.buscarPorId(id);
    }
}