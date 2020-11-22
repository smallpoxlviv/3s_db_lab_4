package ua.iot.lviv.model;

public interface Diagnosis extends GeneralModel {
    String getDiagnosis();
    void setDiagnosis(String diagnosis);
    String getTreatment();
    void setTreatment(String treatment);
}
