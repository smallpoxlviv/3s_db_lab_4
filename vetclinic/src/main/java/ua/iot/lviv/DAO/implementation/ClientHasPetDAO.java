package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.ClientHasPet;
import ua.iot.lviv.model.implementation.ClientHasPetImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ClientHasPetDAO implements GeneralDAO<ClientHasPet, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.client_has_pet";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.client_has_pet WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.client_has_pet "
            + "(id, client_id, pet_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.client_has_pet"
            + " SET client_id=?, pet_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.client_has_pet WHERE id=?";

    @Override
    public List<ClientHasPet> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<ClientHasPet> clientHasPets = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer clientId = resultSet.getInt(2);
                    Integer petId = resultSet.getInt(3);
                    clientHasPets.add(new ClientHasPetImpl(id, clientId, petId));
                }
            }
        }
        return clientHasPets;
    }

    @Override
    public ClientHasPet getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        ClientHasPet clientHasPet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer clientId = resultSet.getInt(2);
                    Integer petId = resultSet.getInt(3);
                    clientHasPet = new ClientHasPetImpl(id, clientId, petId);
                }
            }
        }
        return clientHasPet;
    }

    @Override
    public int create(ClientHasPet entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getClientId());
            pstatement.setInt(3, entity.getPetId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(ClientHasPet entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getClientId());
            pstatement.setInt(2, entity.getPetId());
            pstatement.setInt(3, entity.getId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(DELETE)) {
            pstatement.setInt(1, id);
            return pstatement.executeUpdate();
        }
    }
}
