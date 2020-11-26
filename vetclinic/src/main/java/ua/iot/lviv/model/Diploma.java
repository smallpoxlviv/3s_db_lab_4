package ua.iot.lviv.model;

import java.time.LocalDate;

public interface Diploma extends GeneralModel {
    String getUniversity();
    void setUniversity(String university);
    LocalDate getDate();
    void setDate(LocalDate date);
    String getSeria();
    void setSeria(String seria);
    String getNumber();
    void setNumber(String number);
    Integer getDoctorId();
    void setDoctorId(Integer doctorId);
}
