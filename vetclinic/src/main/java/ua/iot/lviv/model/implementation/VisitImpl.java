package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Visit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class VisitImpl implements Visit {
    private Integer id;
    private LocalDateTime dateTime;
    private Integer clientHasPetId;
    private Integer serviceId;
    private Integer scheduleId;
    private Integer diagnosisId;

    public VisitImpl(Integer id, LocalDateTime dateTime, Integer clientHasPetId, Integer serviceId, Integer scheduleId, Integer diagnosisId) {
        this.id = id;
        this.dateTime = dateTime;
        this.clientHasPetId = clientHasPetId;
        this.serviceId = serviceId;
        this.scheduleId = scheduleId;
        this.diagnosisId = diagnosisId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public Integer getClientHasPetId() {
        return clientHasPetId;
    }

    @Override
    public Integer getServiceId() {
        return serviceId;
    }

    @Override
    public Integer getScheduleId() {
        return scheduleId;
    }

    @Override
    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void setClientHasPetId(Integer clientHasPetId) {
        this.clientHasPetId = clientHasPetId;
    }

    @Override
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Override
    public String toString() {
        return "VisitImpl{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", clientHasPetId=" + clientHasPetId +
                ", serviceId=" + serviceId +
                ", scheduleId=" + scheduleId +
                ", diagnosisId=" + diagnosisId +
                '}';
    }
}
