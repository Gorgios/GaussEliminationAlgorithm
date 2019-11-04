package com.ug;

public class Matrix<T extends Number> {
   private T[][] matrix;
   private int columns;
   private int rows;
   private Class<T> type;
   private RandomGenerator[][] intMatrix;

   public Matrix(int columns,int rows, Class<T> type, RandomGenerator[][] intMatrix){
       this.columns = columns;
       this.rows = rows;
       this.type = type;
       this.intMatrix = intMatrix;
       this.matrix = (T[][]) new Number[rows][columns];
   }
    public void generateMatrix()  {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (type.equals(Float.class))
                    matrix[i][j] = (T) Float.valueOf(( float) intMatrix[i][j].getResult() / (float) intMatrix[i][j].getDivider());
                else if (type.equals(Double.class))
                    matrix[i][j] = (T) Double.valueOf(( double) intMatrix[i][j].getResult() / (double) intMatrix[i][j].getDivider());
            }
    }
    public void printMatrix() {
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++)
                System.out.print(matrix[j][i] + "  ");
            System.out.print("\n");
        }
    }
}
