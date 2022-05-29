package com.yousuf.fhir;

import org.hl7.fhir.r4.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ObservationProvider {

    public Observation getRbcObservation(String seqN, Patient patient){

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

    public Observation getEkgObservation(String seqN, Patient patient){
        int[] ekgData = DataGenerator.getRandomEkgData(100);
        String ekgStringData = Arrays.stream(ekgData).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println("Ecg Sample Data: " + ekgStringData);
        String timestamp = "2020-11-18T08:50:09.322Z";

        Observation ekgObservation = new Observation();
        ekgObservation.setId("Observation/ekg-" + seqN);
        ekgObservation.setStatus(Observation.ObservationStatus.FINAL);
        ekgObservation.setEffective(new DateTimeType(timestamp));

        Coding ekgCode = new Coding()
                .setSystem("http://loinc.org")
                .setCode("6690-2")
                .setDisplay("Sample ECG data");

        ekgObservation.getCode().addCoding(ekgCode);

        SampledData sampledData = new SampledData()
                .setData(ekgStringData)
                .setLowerLimit(DataGenerator.ekgRangeMin)
                .setUpperLimit(DataGenerator.ekgRangeMax)
                .setDimensions(100)
                .setPeriod(30)
                .setOrigin(new Quantity().setValue(150));

        ekgObservation.setValue(sampledData);
        ekgObservation.setSubject(new Reference("Patient/" + patient.getId()));
        return ekgObservation;
    }

}
