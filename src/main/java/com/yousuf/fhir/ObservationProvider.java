package com.yousuf.fhir;

import org.hl7.fhir.r4.model.*;

import java.math.BigDecimal;

public class ObservationProvider {

    public Observation getObservation(String seqN, Patient patient){

        // White blood cell count - This corresponds to LOINC code:
        // Code:        6690-2
        // Display:     Leukocytes [#/volume] in Blood by Automated count
        // Unit System: http://unitsofmeasure.org
        // Unit Code:   10*3/uL
        String rbc = "9.4";  //nextRecord.get("RBC");

        String timestamp = "2020-11-18T08:50:09.322Z";

        // Create the RBC Observation
        Observation rbcObservation = new Observation();
        rbcObservation.setId("Observation/rbc-" + seqN);
        rbcObservation.setStatus(Observation.ObservationStatus.FINAL);
        rbcObservation.setEffective(new DateTimeType(timestamp));
        Coding rbcCode = new Coding()
                .setSystem("http://loinc.org")
                .setCode("6690-2")
                .setDisplay("Leukocytes [#/volume] in Blood by Automated count");
        rbcObservation.getCode().addCoding(rbcCode);
        Quantity rbcValue = new SimpleQuantity()
                .setSystem("http://unitsofmeasure.org")
                .setUnit("10*3/uL")
                .setCode("10*3/uL")
                .setValue(new BigDecimal(rbc));
        rbcObservation.setValue(rbcValue);
        rbcObservation.setSubject(new Reference("Patient/" + patient.getId()));

        return rbcObservation;
    }

}
