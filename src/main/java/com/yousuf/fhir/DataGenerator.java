package com.yousuf.fhir;

import java.util.Random;

public class DataGenerator {

    public static final int ekgRangeMin = 0;
    public static final int ekgRangeMax = 200;

    public static int[] getRandomEkgData(int total){
        int data[] = new int[total];
        //DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Random random = new Random();
        for(int i=0; i<total; i++){
            //double val  = ekgRangeMin + (ekgRangeMax - ekgRangeMin) * random.nextDouble();
            data[i]  =  random.nextInt(ekgRangeMax);
            //data[i] =  Double.parseDouble(decimalFormat.format(val));
            //System.out.print(data[i] + " ");
        }
        //System.out.println();
        return data;
    }
}
