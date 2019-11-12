package com.ug;

public class ErrorCounter {
    public static float floatError(Matrix vectorIn, Matrix vectorOut,int size){
        float err=0;
        for (int i=0; i<size;i++)
            err+=Math.abs((Float)vectorOut.matrix[i][0] - (Float)vectorIn.matrix[i][0]);
        return err/size;
    }
    public static double doubleError(Matrix vectorIn, Matrix vectorOut,int size){
        float err=0;
        for (int i=size - size/3; i<size;i++)
            err+=Math.abs((Double)vectorOut.matrix[i][0] - (Double)vectorIn.matrix[i][0]);
        return err/size;
    }
}
