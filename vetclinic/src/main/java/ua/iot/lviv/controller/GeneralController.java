package ua.iot.lviv.controller;

import ua.iot.lviv.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T> {
    void getAll() throws SQLException;
    void getById(Integer id) throws SQLException;
    void create(T entity) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(Integer id) throws SQLException;

    GeneralService<T> getService();
}
