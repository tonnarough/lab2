package com.company;

public class CalculateMath {

    public static Double Calculate1(double x, double y, double z)
    {
        return (Math.pow((Math.log(Math.pow((1+x),2)) + Math.cos(Math.PI*z*z*z)),Math.sin(y)) + Math.pow((Math.pow(Math.E,x*x) + Math.cos(Math.pow(Math.E,z)) + Math.sqrt(1/y)),1/x));
    }

    public static Double Calculate2(double x, double y, double z)
    {
        return Math.pow(Math.cos(Math.pow(Math.PI*x, 3)) + Math.pow(Math.log(1+y), 2), 4)*(Math.pow(Math.E, Math.pow(z, 2)) + Math.pow(1/x, 1/2) + Math.cos(Math.pow(Math.E, y)));
    }

}