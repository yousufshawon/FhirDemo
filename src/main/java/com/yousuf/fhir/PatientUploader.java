package com.yousuf.fhir;

import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.*;

public class PatientUploader {

    public void upload(){

        // Create a FHIR client
        IGenericClient client = FhirConfig.getClient();
        IParser parser = FhirConfig.getParser();
        Patient patient = new PatientProvider().getPatient();
        // upload patient
        //updatePatient(client, patient);
        // Read Patient
        //readPatient(client, patient, parser);

        String seqN = "93704.0";

        Observation rbsObservation = new ObservationProvider().getObservation(seqN, patient);
        //uploadObservation(client, rbsObservation);

        readObservationById("Observation/rbc-" + seqN, client, parser);

    }

    private void updatePatient(IGenericClient client, Patient patient){

        // Upload the patient resource using a client-assigned ID create
        client.update().resource(patient).execute();

    }

    private void readPatient(IGenericClient client, Patient patient, IParser parser){

        Patient patientRead = client.read().resource(Patient.class).withId(patient.getId()).execute();
        System.out.println("Got read response for Patient");
        System.out.println(parser.encodeResourceToString(patientRead));
    }

    private void uploadObservation(IGenericClient client, Observation observation){
        // Upload the RBC Observation resource using a client-assigned ID create
        client.update().resource(observation).execute();
    }

    private void readObservationById(String observationId, IGenericClient client, IParser parser){
        Observation observationRead = client.read().resource(Observation.class).withId(observationId).execute();
        System.out.println("Got read response for Patient Observation");
        System.out.println(parser.encodeResourceToString(observationRead));
    }



}
