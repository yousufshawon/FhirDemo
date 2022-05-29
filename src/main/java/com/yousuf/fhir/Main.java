package com.yousuf.fhir;

public class Main {

    public static void main(String[] args) {

        System.out.println("Project started");

        new PatientUploader().upload();

        System.out.println("Project finished");
    }


}
