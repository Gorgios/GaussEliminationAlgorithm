package com.ug;

public class Tests {
    //Print matrix for test
    public static void GenerateAndPrint(int size) {
        RandomGenerator[][] matrix = new RandomGenerator[size][size];
        matrix = RandomGenerator.generateMatrix(size);
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++)
                System.out.print(matrix[j][i].getResult()/matrix[i][j].getDivider() + "  ");
            System.out.print("\n");
        }
    }
}
