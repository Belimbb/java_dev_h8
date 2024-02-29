package org.example.serviceClasses;

import org.example.Database;
import org.example.entityСlasses.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final Connection CONNECTION = Database.getConnection();
    private ClientService(){

    }
    public static long create(String name) throws SQLException {
        String insertRequest = "INSERT INTO client (name) VALUES (?)";

        PreparedStatement insert = CONNECTION.prepareStatement(insertRequest, Statement.RETURN_GENERATED_KEYS);
        insert.setString(1, name);
        insert.executeUpdate();

        long clientId = -1;
        try (ResultSet generatedKeys = insert.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                clientId = generatedKeys.getLong(1);
            }
        }

        if (clientId == -1) {
            String searchRequest = "SELECT id FROM public.client c WHERE \"name\" = ?";
            PreparedStatement search = CONNECTION.prepareStatement(searchRequest);
            search.setString(1, name);
            ResultSet resultSet = search.executeQuery();
            if (resultSet.next()) {
                clientId = resultSet.getLong(1);
            }
        }

        return clientId;
    }

    public static String getById(long id) throws SQLException {
        String searchRequest = "select name from public.client c where id=?;";

        PreparedStatement search = CONNECTION.prepareStatement(searchRequest);
        search.setLong(1, id);
        ResultSet resultSet = search.executeQuery();
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return "Nothing found";
    }

    public static void setName(long id, String name) throws SQLException {
        String insertRequest = "update public.client set \"name\"= ? where client.id = ?;";

        PreparedStatement insert = CONNECTION.prepareStatement(insertRequest);
        insert.setString(1, name);
        insert.setLong(2, id);
        insert.execute();
    }

    public static void deleteById(long id) throws SQLException {
        String deleteRequest = "delete from public.client where id=?;";

        PreparedStatement insert = CONNECTION.prepareStatement(deleteRequest);
        insert.setLong(1, id);
        insert.execute();
    }

    public static List<Client> listAll() throws SQLException {
        String searchRequest = "select * from public.client c;";
        List<Client> clients = new ArrayList<>();

        PreparedStatement search = CONNECTION.prepareStatement(searchRequest);
        ResultSet resultSet = search.executeQuery();

        while (resultSet.next()){
            clients.add(new Client(resultSet.getLong("id"), resultSet.getString("name")));
        }
        return clients;
    }
}
