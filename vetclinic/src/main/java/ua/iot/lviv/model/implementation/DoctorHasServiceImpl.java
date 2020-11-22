package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.DoctorHasService;

public class DoctorHasServiceImpl implements DoctorHasService {
    private Integer id;
    private Integer doctorId;
    private Integer serviceId;

    public DoctorHasServiceImpl(Integer id, Integer doctorId, Integer serviceId) {
        this.id = id;
        this.doctorId = doctorId;
        this.serviceId = serviceId;
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
    public Integer getServiceId() {
        return serviceId;
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
    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "DoctorHasServiceImpl{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", serviceId=" + serviceId +
                '}';
    }
}
