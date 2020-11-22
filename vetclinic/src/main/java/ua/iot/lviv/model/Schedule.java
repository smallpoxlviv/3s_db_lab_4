package ua.iot.lviv.model;

import java.sql.Time;

public interface Schedule extends GeneralModel {
    Integer getDoctorId();
    void setDoctorId(Integer doctorId);
    Time getTimeStart();
    void setTimeStart(Time timeStart);
    Time getTimeEnd();
    void setTimeEnd(Time timeEnd);
    String getWeekDay();
    void setWeekDay(String weekDay);
}
