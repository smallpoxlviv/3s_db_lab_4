package ua.iot.lviv.controller.implementation;

import ua.iot.lviv.model.Schedule;
import ua.iot.lviv.service.GeneralService;
import ua.iot.lviv.service.implementation.ScheduleService;

public class ScheduleController extends GeneralControllerImpl<Schedule> {
    private GeneralService<Schedule> scheduleService = new ScheduleService();

    @Override
    public GeneralService<Schedule> getService() {
        return scheduleService;
    }
}
