package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.DoctorHasService;
import ua.iot.lviv.model.implementation.DoctorHasServiceImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DoctorHasServiceDAO implements GeneralDAO<DoctorHasService, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.doctor_has_service";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.doctor_has_service WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.doctor_has_service "
            + "(id, doctor_id, service_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.doctor_has_service"
            + " SET doctor_id=?, service_id=?  WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.doctor_has_service WHERE id=?";

    @Override
    public List<DoctorHasService> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<DoctorHasService> doctorHasServices = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer doctorId = resultSet.getInt(2);
                    Integer serviceId = resultSet.getInt(3);
                    doctorHasServices.add(new DoctorHasServiceImpl(id, doctorId, serviceId));
                }
            }
        }
        return doctorHasServices;
    }

    @Override
    public DoctorHasService getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        DoctorHasService doctorHasService = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer doctorId = resultSet.getInt(2);
                    Integer serviceId = resultSet.getInt(3);
                    doctorHasService = new DoctorHasServiceImpl(id, doctorId, serviceId);
                }
            }
        }
        return doctorHasService;
    }

    @Override
    public int create(DoctorHasService entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getDoctorId());
            pstatement.setInt(3, entity.getServiceId());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(DoctorHasService entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getDoctorId());
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