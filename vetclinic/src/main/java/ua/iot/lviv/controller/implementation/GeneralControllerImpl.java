package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.controller.GeneralController;
import ua.iot.lviv.service.GeneralService;

import java.sql.SQLException;
import java.util.List;

public abstract class GeneralControllerImpl<T> implements GeneralController<T> {

    @Override
    public abstract GeneralService<T> getService();

    @Override
    public void getAll() throws SQLException {
        List<T> listObj =  getService().getAll();
        if (listObj.isEmpty()) {
            System.out.println("Table is empty");
        } else {
            for (T obj: listObj) {
                System.out.println(obj);
            }
        }
    }

    @Override
    public void getById(Integer id) throws SQLException {
        T obj = getService().getById(id);
        if (obj != null) {
            System.out.println("Entity with id= " + id + ":");
            System.out.println(obj);
        } else {
            System.out.println("Entity with id= " + id + " not found");
        }
    }

    @Override
    public void create(T entity) throws SQLException {
        int res = getService().create(entity);
        if (res != 0) {
            System.out.println("Entity has been created");
        }
    }

    @Override
    public void update(T entity) throws SQLException {
        int res = getService().update(entity);
        if (res != 0) {
            System.out.println("Entity has been updated:");
            System.out.println(entity);
        } else {
            System.out.println("There is no entity with such id");
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        int res = getService().delete(id);
        if (res != 0) {
            System.out.println("Entity with id " + id + " has been deleted");
        } else {
            System.out.println("There is no entity with such id");
        }
    }
}