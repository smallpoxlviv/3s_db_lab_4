package ua.iot.lviv.model;

public interface DoctorHasService extends GeneralModel{
    Integer getDoctorId();
    void setDoctorId(Integer doctorId);
    Integer getServiceId();
    void setServiceId(Integer serviceId);
}
