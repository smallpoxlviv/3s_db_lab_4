package ua.iot.lviv.DAO.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.model.Schedule;
import ua.iot.lviv.model.implementation.ScheduleImpl;
import ua.iot.lviv.persistant.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ScheduleDAO implements GeneralDAO<Schedule, Integer> {
    private static final String GET_ALL = "SELECT * FROM s3_db_lab_4.schedule";
    private static final String GET_BY_ID = "SELECT * FROM s3_db_lab_4.schedule WHERE id=?";
    private static final String CREATE = "INSERT s3_db_lab_4.schedule "
            + "(id, doctor_id, time_start, time_end, week_day) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE s3_db_lab_4.schedule"
            + " SET doctor_id=?, time_start=?, time_end=?, week_day=? WHERE id=?";
    private static final String DELETE = "DELETE FROM s3_db_lab_4.schedule WHERE id=?";

    @Override
    public List<Schedule> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Schedule> schedules = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer doctorId = resultSet.getInt(2);
                    Time timeStart = resultSet.getTime(3);
                    Time timeEnd = resultSet.getTime(4);
                    String weekDay = resultSet.getString(5);
                    schedules.add(new ScheduleImpl(id, doctorId, timeStart, timeEnd, weekDay));
                }
            }
        }
        return schedules;
    }

    @Override
    public Schedule getById(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Schedule schedule = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer doctorId = resultSet.getInt(2);
                    Time timeStart = resultSet.getTime(3);
                    Time timeEnd = resultSet.getTime(4);
                    String weekDay = resultSet.getString(5);
                    schedule = new ScheduleImpl(id, doctorId, timeStart, timeEnd, weekDay);
                }
            }
        }
        return schedule;
    }

    @Override
    public int create(Schedule entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(CREATE)) {
            pstatement.setInt(1, entity.getId());
            pstatement.setInt(2, entity.getDoctorId());
            pstatement.setTime(3, entity.getTimeStart());
            pstatement.setTime(4, entity.getTimeEnd());
            pstatement.setString(5, entity.getWeekDay());
            return pstatement.executeUpdate();
        }
    }

    @Override
    public int update(Schedule entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement pstatement = connection.prepareStatement(UPDATE)) {
            pstatement.setInt(1, entity.getDoctorId());
            pstatement.setTime(2, entity.getTimeStart());
            pstatement.setTime(3, entity.getTimeEnd());
            pstatement.setString(4, entity.getWeekDay());
            pstatement.setInt(5, entity.getId());
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
