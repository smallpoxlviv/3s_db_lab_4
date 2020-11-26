package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Diploma;

import java.time.LocalDate;
import java.util.Date;

public class DiplomaImpl implements Diploma {
    private Integer id;
    private String university;
    private LocalDate date;
    private String seria;
    private String number;
    private Integer doctorId;

    public DiplomaImpl(Integer id, String university, LocalDate date, String seria, String number, Integer doctorId) {
        this.id = id;
        this.university = university;
        this.date = date;
        this.seria = seria;
        this.number = number;
        this.doctorId = doctorId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getSeria() {
        return seria;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public Integer getDoctorId() {
        return doctorId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void setSeria(String seria) {
        this.seria = seria;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "DiplomaImpl{" +
                "id=" + id +
                ", university='" + university + '\'' +
                ", date=" + date +
                ", seria='" + seria + '\'' +
                ", number='" + number + '\'' +
                ", doctorId='" + doctorId + '\'' +
                '}';
    }
}
