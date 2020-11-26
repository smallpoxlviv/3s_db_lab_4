package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.AnimalSpeciesHasService;
import ua.iot.lviv.model.implementation.AnimalSpeciesHasServiceImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class AnimalSpeciesHasServiceDAO implements GeneralDAO<AnimalSpeciesHasService, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.animal_species_has_service";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.animal_species_has_service WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.animal_species_has_service "
            + "(id, animal_species_id, service_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.animal_species_has_service"
            + " SET animal_species_id=?, service_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.animal_species_has_service WHERE id=?";

    @Override
    public List<AnimalSpeciesHasService> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<AnimalSpeciesHasService> animalSpeciesHasServices = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer animalSpeciesId = resultSet.getInt(2);
                    Integer serviceId = resultSet.getInt(3);
                    animalSpeciesHasServices.add(new AnimalSpeciesHasServiceImpl(id, animalSpeciesId, serviceId));
                }
            }
        }
        return animalSpeciesHasServices;
    }

    @Override
    public AnimalSpeciesHasService getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        AnimalSpeciesHasService animalSpeciesHasService = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer animalSpeciesId = resultSet.getInt(2);
                    Integer serviceId = resultSet.getInt(3);
                    animalSpeciesHasService = new AnimalSpeciesHasServiceImpl(id, animalSpeciesId, serviceId);
                }
            }
        }
        return animalSpeciesHasService;
    }

    @Override
    public int create(AnimalSpeciesHasService entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getAnimalSpeciesId());
            pstatement.setInt(3, entity.getServiceId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(AnimalSpeciesHasService entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getAnimalSpeciesId());
            pstatement.setInt(2, entity.getServiceId());
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