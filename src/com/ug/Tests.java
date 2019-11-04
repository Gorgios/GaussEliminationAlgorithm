package com.ug;

public class Tests {
    //Print matrix for test
    public static boolean isMatrixOk(int size) {
        RandomGenerator[][] matrix = new RandomGenerator[size][size];
        matrix = RandomGenerator.generateMatrix(size);
        for (int j = 0; j < size; j++)
            for (int i = 0; i < size; i++)
                if((matrix[j][i].getResult()/matrix[i][j].getDivider() > 1 )|| (matrix[j][i].getResult()/matrix[i][j].getDivider() < -1))
                    return false;
        return true;
    }

}
