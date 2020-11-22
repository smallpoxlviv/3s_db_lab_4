package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.Diploma;
import ua.iot.lviv.model.implementation.DiplomaImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DiplomaDAO implements GeneralDAO<Diploma, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.diploma";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.diploma WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.diploma "
            + "(id, university, date, seria, number, doctor_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.diploma"
            + " SET university=?, date=?, seria=?, number=?, doctor_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.diploma  WHERE id=?";

    @Override
    public List<Diploma> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Diploma> diplomas = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String university = resultSet.getString(2);
                    LocalDate date = resultSet.getObject(3, LocalDate.class);
                    String seria = resultSet.getString(4);
                    String number = resultSet.getString(5);
                    Integer doctorId = resultSet.getInt(6);
                    diplomas.add(new DiplomaImpl(id, university, date, seria, number, doctorId));
                }
            }
        }
        return diplomas;
    }

    @Override
    public Diploma getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Diploma diploma = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String university = resultSet.getString(2);
                    LocalDate date = resultSet.getObject(3, LocalDate.class);
                    String seria = resultSet.getString(4);
                    String number = resultSet.getString(5);
                    Integer doctorId = resultSet.getInt(6);
                    diploma = new DiplomaImpl(id, university, date, seria, number, doctorId);
                }
            }
        }
        return diploma;
    }

    @Override
    public int create(Diploma entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setString(2, entity.getUniversity());
            pstatement.setObject(3, entity.getDate());
            pstatement.setString(4, entity.getSeria());
            pstatement.setString(5, entity.getNumber());
            pstatement.setInt(6, entity.getDoctorId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Diploma entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setString(1, entity.getUniversity());
            pstatement.setObject(2, entity.getDate());
            pstatement.setString(3, entity.getSeria());
            pstatement.setString(4, entity.getNumber());
            pstatement.setInt(5, entity.getDoctorId());
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
