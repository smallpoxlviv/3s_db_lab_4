package ua.iot.lviv.model.implementation;

import ua.iot.lviv.model.Diagnosis;

public class DiagnosisImpl implements Diagnosis {
    private Integer id;
    private String diagnosis;
    private String treatment;

    public DiagnosisImpl(Integer id, String diagnosis, String treatment) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String getTreatment() {
        return treatment;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "DiagnosisImpl{" +
                "id=" + id +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
