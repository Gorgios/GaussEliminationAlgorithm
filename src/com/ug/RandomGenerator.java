package com.ug;

import java.util.Random;

public class RandomGenerator {
    private int result;
    private int min= -65536;
    private int max= 65335;
    private int divider=65536;

    Random rand = new Random();

    public RandomGenerator(){
        this.result = rand.nextInt(max - min + 1) + min;
    }

    public int getDivider() {
        return divider;
    }

    public double getResult() {
        return result;
    }

    public static RandomGenerator[][] generateMatrix(int size) {
        RandomGenerator[][] matrix = new RandomGenerator[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                matrix[i][j] = new RandomGenerator();
        return matrix;
    }
    public static RandomGenerator[][] generateVector(int size){
        RandomGenerator[][] vector = new RandomGenerator[size][1];
        for (int i=0;i<size;i++)
            vector[i][0]= new RandomGenerator();
        return vector;
    }

}
