package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.Service;
import ua.iot.lviv.model.implementation.ServiceImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.math.BigDecimal;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ServiceDAO implements GeneralDAO<Service, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.service";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.service WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.service "
            + "(id, name, description, price_usd) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.service"
            + " SET name=?, description=?, price_usd=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.service WHERE id=?";

    @Override
    public List<Service> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Service> services = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    BigDecimal priceUSD = resultSet.getBigDecimal(4);
                    services.add(new ServiceImpl(id, name, description, priceUSD));
                }
            }
        }
        return services;
    }

    @Override
    public Service getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Service service = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    BigDecimal priceUSD = resultSet.getBigDecimal(4);
                    service = new ServiceImpl(id, name, description, priceUSD);
                }
            }
        }
        return service;
    }

    @Override
    public int create(Service entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getName());
            pstatement.setString(3, entity.getDescription());
            pstatement.setBigDecimal(4, entity.getPriceUSD());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Service entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getName());
            pstatement.setString(2, entity.getDescription());
            pstatement.setBigDecimal(3, entity.getPriceUSD());
            pstatement.setInt(4, entity.getId());
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
