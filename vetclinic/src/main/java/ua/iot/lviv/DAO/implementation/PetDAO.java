package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.Pet;
import ua.iot.lviv.model.implementation.PetImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PetDAO implements GeneralDAO<Pet, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.pet";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.pet WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.pet "
            + "(id, animal_species_id, name, weight_kg, length_cm, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.pet"
            + " SET animal_species_id=?, name=?, weight_kg=?, length_cm=?, date_of_birth=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.pet WHERE id=?";

    @Override
    public List<Pet> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Pet> pets = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer animalSpeciesId = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    Integer weightInKg = resultSet.getInt(4);
                    Integer lengthInCm = resultSet.getInt(5);
                    LocalDate dateOfBirth = resultSet.getObject(6, LocalDate.class);
                    pets.add(new PetImpl(id, animalSpeciesId, name, weightInKg, lengthInCm, dateOfBirth));
                }
            }
        }
        return pets;
    }

    @Override
    public Pet getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Pet pet = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer animalSpeciesId = resultSet.getInt(2);
                    String name = resultSet.getString(3);
                    Integer weightInKg = resultSet.getInt(4);
                    Integer lengthInCm = resultSet.getInt(5);
                    LocalDate dateOfBirth = resultSet.getObject(6, LocalDate.class);
                    pet = new PetImpl(id, animalSpeciesId, name, weightInKg, lengthInCm, dateOfBirth);
                }
            }
        }
        return pet;
    }

    @Override
    public int create(Pet entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getAnimalSpeciesId());
            pstatement.setString(3, entity.getName());
            pstatement.setInt(4, entity.getWeightInKg());
            pstatement.setInt(5, entity.getLengthInCm());
            pstatement.setObject(6, entity.getDateOfBirth());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Pet entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getAnimalSpeciesId());
            pstatement.setString(2, entity.getName());
            pstatement.setInt(3, entity.getWeightInKg());
            pstatement.setInt(4, entity.getLengthInCm());
            pstatement.setObject(5, entity.getDateOfBirth());
            pstatement.setInt(6, entity.getId());
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
