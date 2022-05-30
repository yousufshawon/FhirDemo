package com.yousuf.fhir;

import java.util.Random;

public class DataGenerator {

    public static final int ekgRangeMin = 0;
    public static final int ekgRangeMax = 200;

    public static final int ekgLowerLimit = -3300;
    public static final int ekgUpperLimit = 3300;
    public static final int ekgOrigin = 2048;
    public static final int ekgPeriod = 10;
    public static final double ekgFactor = 1.612;
    public static final int ekgDimensions = 1;

    private static final String sampleEcgData = "2041 2043 2037 2047 2060 2062 2051 2023 2014 2027 2034 2033 2040 2047 2047 2053 2058 2064 2059 2063 2061 2052 2053 2038 1966 1885 1884 2009 2129 2166 2137 2102 2086 2077 2067 2067 2060 2059 2062 2062 2060 2057 2045 2047 2057 2054 2042 2029 2027 2018 2007 1995 2001 2012 2024 2039 2068 2092 2111 2125 2131 2148 2137 2138 2128 2128 2115 2099 2097 2096 2101 2101 2091 2073 2076 2077 2084 2081 2088 2092 2070 2069 2074 2077 2075 2068 2064 2060 2062 2074 2075 2074 2075 2063 2058 2058 2064 2064 2070 2074 2067 2060 2062 2063 2061 2059 2048 2052 2049 2048 2051 2059 2059 2066 2077 2073";


    public static int[] getRandomEkgData(int total){
        int[] data = new int[total];
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

    public static String getSampleEcgData(){
        return sampleEcgData;
    }
}
