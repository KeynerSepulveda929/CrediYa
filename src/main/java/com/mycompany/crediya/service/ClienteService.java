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

    public boolean registrarCliente(Cliente cliente) {

        if (cliente.getNombre() == null ||
            cliente.getNombre().isBlank()) {

            System.out.println("El nombre es obligatorio.");
            return false;
        }

        if (cliente.getDocumento() == null ||
            cliente.getDocumento().isBlank()) {

            System.out.println("El documento es obligatorio.");
            return false;
        }

        return clienteDAO.guardar(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarPorId(id);
    }
}