package org.example;

import org.example.entityСlasses.Client;
import org.example.serviceClasses.ClientService;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //INIT AND POPULATE DB (MIGRATIONS)
        DatabaseInit.initDatabase();

        //CREATE NEW CLIENT
        try {
            ClientService.create("Bogdan");
        } catch (SQLException e) {
            throw new RuntimeException(e + "\n some problems with creating new client");
        }

        //GET CLIENT BY ID
        try {
            String client = ClientService.getById(4L);
        } catch (SQLException e) {
            throw new RuntimeException(e + "\n some problems with getting client by ID");
        }

        //SET CLIENT NAME
        try {
            ClientService.setName(3L, "Pasha");
        } catch (SQLException e) {
            throw new RuntimeException(e + "\n some problems with setting client name");
        }

        //DELETE CLIENT BY ID
        try {
            ClientService.deleteById(8L);
        } catch (SQLException e) {
            throw new RuntimeException(e + "\n some problems with deleting client");
        }

        //GET ALL CLIENTS
        try {
            List<Client> clients = ClientService.listAll();
        } catch (SQLException e) {
            throw new RuntimeException(e + "\n some problems with getting all clients");
        }
    }
}
