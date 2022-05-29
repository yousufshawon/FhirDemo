package com.yousuf.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;

public class FhirConfig {

    static String SERVER_URL_HAPI_FHIR = "http://hapi.fhir.org/baseR4";
    static String SERVER_URL_FHIR_TEST = "http://fhirtest.uhn.ca/baseR4";
    static String SERVER_URL_SERVER_FIRE_LY = "https://server.fire.ly";
    static String SERVER_URL_SERVER_FIRE_LY_R4 = "https://server.fire.ly/baseR4";

    private static FhirContext ctx;
    private static IGenericClient client;
    private static IParser parser;


    public static IGenericClient getClient(){
        if (client == null){
            client = getContext().newRestfulGenericClient(FhirConfig.SERVER_URL_SERVER_FIRE_LY);
            client.registerInterceptor(new LoggingInterceptor(false));
        }
        return client;
    }

    private static FhirContext getContext(){
        if (ctx == null){
            ctx = FhirContext.forR4();
        }
        return ctx;
    }

    public static IParser getParser(){
        if (parser == null){
            parser = getContext().newJsonParser().setPrettyPrint(true);
        }
        return parser;
    }



}
