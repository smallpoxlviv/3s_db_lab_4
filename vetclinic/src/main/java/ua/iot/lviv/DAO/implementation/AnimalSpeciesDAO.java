package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.AnimalSpecies;
import ua.iot.lviv.model.implementation.AnimalSpeciesImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AnimalSpeciesDAO implements GeneralDAO<AnimalSpecies, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.animal_species";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.animal_species WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.animal_species "
            + "(id, species) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.animal_species"
            + " SET species=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.animal_species WHERE id=?";

    @Override
    public List<AnimalSpecies> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<AnimalSpecies> animalSpecies = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String species = resultSet.getString(2);
                    animalSpecies.add(new AnimalSpeciesImpl(id, species));
                }
            }
        }
        return animalSpecies;
    }

    @Override
    public AnimalSpecies getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        AnimalSpecies animalSpecies = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String species = resultSet.getString(2);
                    animalSpecies = new AnimalSpeciesImpl(id, species);
                }
            }
        }
        return animalSpecies;
    }

    @Override
    public int create(AnimalSpecies entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getSpecies());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(AnimalSpecies entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getSpecies());
            pstatement.setInt(2, entity.getId());
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
