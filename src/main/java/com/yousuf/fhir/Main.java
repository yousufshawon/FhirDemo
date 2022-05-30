package com.yousuf.fhir;

public class Main {

    public static void main(String[] args) {

        System.out.println("Project started");
        //new PatientUploader().upload();
        new SearchProvider().searchPatientByCity("Dhaka");
        System.out.println("Project finished");
    }


}
