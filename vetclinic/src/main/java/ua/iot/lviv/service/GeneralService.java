package ua.iot.lviv.service;

import ua.iot.lviv.DAO.GeneralDAO;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {
    List<T> getAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    int create(T entity) throws SQLException;
    int update(T entity) throws SQLException;
    int delete(Integer id) throws SQLException;

    GeneralDAO<T, Integer> getDAO();
}
