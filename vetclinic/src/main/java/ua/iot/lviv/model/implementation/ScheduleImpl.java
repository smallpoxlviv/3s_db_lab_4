package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Schedule;

import java.sql.Time;

public class ScheduleImpl implements Schedule {
    private Integer id;
    private Integer doctorId;
    private Time timeStart;
    private Time timeEnd;
    private String weekDay;

    public ScheduleImpl(Integer id, Integer doctorId, Time timeStart, Time timeEnd, String weekDay) {
        this.id = id;
        this.doctorId = doctorId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.weekDay = weekDay;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getDoctorId() {
        return doctorId;
    }

    @Override
    public Time getTimeStart() {
        return timeStart;
    }

    @Override
    public Time getTimeEnd() {
        return timeEnd;
    }

    @Override
    public String getWeekDay() {
        return weekDay;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public void setTimeStart(Time timeStart) {
        this.timeStart = timeStart;
    }

    @Override
    public void setTimeEnd(Time timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return "ScheduleImpl{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", weekDay='" + weekDay + '\'' +
                '}';
    }
}
