package com.yousuf.fhir;

import org.hl7.fhir.r4.model.Patient;

public class LogUtil {

    public static String getPatientInfo(Patient patient){
        StringBuilder sb = new StringBuilder();
        sb.append("Url Id:").append(patient.getId()).append("\n");
        sb.append("Id:").append(patient.getIdElement().getIdPart()).append("\n");

        sb.append("Name: ");
        if (patient.getName().size() > 0){
            sb.append(patient.getName().get(0).getNameAsSingleString());
        }
        sb.append("\n");
        sb.append("Address:");
        if (patient.getAddress().size() > 0) {
            sb.append(patient.getAddress().get(0).getState()).append(",").append(patient.getAddress().get(0).getCity()).append(",").append(patient.getAddress().get(0).getCountry());
        }
        sb.append("\n");
        return sb.toString();
    }
}
