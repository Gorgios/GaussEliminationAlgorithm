package com.ug;

public class Main {

    public static void main(String[] args) {
       // Tests.GenerateAndPrint(1000);
       int size = 10;
       RandomGenerator intMatrix[][] = new RandomGenerator[size][size];
       intMatrix=RandomGenerator.generateMatrix(size);
       Matrix matrix = new Matrix(size,size,Double.class,intMatrix);
       matrix.generateMatrix();
       matrix.printMatrix();
    }
}
