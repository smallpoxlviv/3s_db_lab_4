package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.Doctor;
import ua.iot.lviv.model.implementation.DoctorImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DoctorDAO implements GeneralDAO<Doctor, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.doctor";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.doctor WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.doctor "
            + "(id, first_name, name, last_name, year_of_birth, speciality) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.doctor"
            + " SET first_name=?, name=?, last_name=?, year_of_birth=?, speciality=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.doctor WHERE id=?";

    @Override
    public List<Doctor> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Doctor> doctors = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    String lastName = resultSet.getString(4);
                    Integer yearOfBirth = resultSet.getInt(5);
                    String speciality = resultSet.getString(6);
                    Integer diplomaId = resultSet.getInt(7);
                    doctors.add(new DoctorImpl(id, firstName, name, lastName, yearOfBirth, speciality));
                }
            }
        }
        return doctors;
    }

    @Override
    public Doctor getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Doctor doctor = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString(2);
                    String name = resultSet.getString(3);
                    String lastName = resultSet.getString(4);
                    Integer yearOfBirth = resultSet.getInt(5);
                    String speciality = resultSet.getString(6);
                    Integer diplomaId = resultSet.getInt(7);
                    doctor = new DoctorImpl(id, firstName, name, lastName, yearOfBirth, speciality);
                }
            }
        }
        return doctor;
    }

    @Override
    public int create(Doctor entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getFirstName());
            pstatement.setString(3, entity.getName());
            pstatement.setString(4, entity.getLastName());
            pstatement.setInt(5, entity.getYearOfBirth());
            pstatement.setString(6, entity.getSpeciality());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Doctor entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getFirstName());
            pstatement.setString(2, entity.getName());
            pstatement.setString(3, entity.getLastName());
            pstatement.setInt(4, entity.getYearOfBirth());
            pstatement.setString(5, entity.getSpeciality());
            pstatement.setInt(7, entity.getId());
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
