package com.yousuf.fhir;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Resource;

public class SearchProvider {

    public void searchPatientByCity(String keyword){
        Bundle results =
        FhirConfig.getClient()
                .search()
                .forResource(Patient.class)
                .where(Patient.ADDRESS.matches().value(keyword))
                .prettyPrint()
                .returnBundle(Bundle.class)
                .encodedJson()
                .execute();

        int totalFound =results.getEntry().size();
        System.out.println("Total " + totalFound + " patient found");

        results.getEntry().forEach(bundleEntryComponent -> {
            Resource resource = bundleEntryComponent.getResource();
            if (resource instanceof Patient){
                Patient patient = (Patient) resource;

                System.out.println(LogUtil.getPatientInfo(patient));
            }else {
                System.out.println("Resource is not Patient. Class: " + resource.getClass().getSimpleName());
                if (resource instanceof OperationOutcome){
                    OperationOutcome operationOutcome = (OperationOutcome) resource;
                }
            }
        });
    }

}
