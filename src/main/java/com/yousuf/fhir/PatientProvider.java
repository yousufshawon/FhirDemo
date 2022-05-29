package com.yousuf.fhir;

import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Patient;

public class PatientProvider {

    public Patient getPatient(){
        //93704.0,2020-11-18T08:50:09.322Z,PT00002,Simpson,Marge,F,7.4,4.25,13.1

        // Sequence number - This could be used as an ID for generated resources
        //String seqN = "93704.0";

        // Timestamp - This will be formatted in ISO8601 format
        String timestamp = "2020-11-18T08:50:09.322Z";

        // Patient ID
        String patientId = "PT00001";

        // Patient Family Name
        //String patientFamilyName = nextRecord.get("PATIENT_FAMILYNAME");
        String patientFamilyName = "Simpson";

        // Patient Given Name
        //String patientGivenName = nextRecord.get("PATIENT_GIVENNAME");
        String patientGivenName = "Marge";

        // Patient Gender - Values will be "M" or "F"
        //String patientGender = nextRecord.get("PATIENT_GENDER");
        String patientGender = "M";

        // Create the Patient resource
        Patient patient = new Patient();
        patient.setId("Patient/" + patientId);
        patient.addName().setFamily(patientFamilyName).addGiven(patientGivenName);

        // Gender code needs to be mapped
        switch (patientGender) {
            case "M":
                patient.setGender(Enumerations.AdministrativeGender.MALE);
                break;
            case "F":
                patient.setGender(Enumerations.AdministrativeGender.FEMALE);
                break;
        }

        return patient;
    }
}
