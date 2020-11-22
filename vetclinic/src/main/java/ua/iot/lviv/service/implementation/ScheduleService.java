package ua.iot.lviv.service.implementation;

import ua.iot.lviv.DAO.GeneralDAO;
import ua.iot.lviv.DAO.implementation.ScheduleDAO;
import ua.iot.lviv.model.Schedule;


public class ScheduleService extends GeneralServiceImpl<Schedule> {
    private final GeneralDAO<Schedule, Integer> scheduleDAO = new ScheduleDAO();

    @Override
    public GeneralDAO<Schedule, Integer> getDAO() {
        return scheduleDAO;
    }
}


