package com.ug;

public class Matrix<T extends Number> {
     T[][] matrix;
     int columns;
     int rows;
     Class<T> type;
     RandomGenerator[][] intMatrix;

    public Matrix(int columns, int rows, Class<T> type, RandomGenerator[][] intMatrix) {
        this.columns = columns;
        this.rows = rows;
        this.type = type;
        this.intMatrix = intMatrix;
        this.matrix = (T[][]) new Number[rows][columns];
    }

    public Matrix(int columns, int rows, Class<T> type) {
        this.columns = columns;
        this.rows = rows;
        this.type = type;
        this.matrix = (T[][]) new Number[rows][columns];
    }

    public Matrix(int rows, Class<T> type) {
        this.columns = 1;
        this.rows = rows;
        this.type = type;
        this.matrix = (T[][]) new Number[rows][columns];
    }

    public void generateMatrix() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (type.equals(Float.class))
                    matrix[i][j] = (T) Float.valueOf((float) intMatrix[i][j].getResult() / (float) intMatrix[i][j].getDivider());
                else if (type.equals(Double.class))
                    matrix[i][j] = (T) Double.valueOf((double) intMatrix[i][j].getResult() / (double) intMatrix[i][j].getDivider());
            }
    }

    public void printMatrix() {
        System.out.println("MACIERZ: ");
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++)
                System.out.print(matrix[j][i] + "  ");
            System.out.print("\n");
        }
    }

    public Matrix<T> methodWithoutChoice(Matrix<T> matrix, Matrix<T> vector, Matrix<T> MatrixCopy) {
        int n = vector.rows;
        Matrix<T> resultVector = new Matrix(n, type);
        Matrix<T> checkingVector = new Matrix(n, type);
        if (type.equals(Float.class)) {
            float multiple ;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    multiple = matrix.matrix[j][i].floatValue() / matrix.matrix[i][i].floatValue();
                    vector.matrix[j][0] = (T) (Float) (vector.matrix[j][0].floatValue() - multiple * vector.matrix[i][0].floatValue());
                    for (int r = i; r < n; r++)
                        matrix.matrix[j][r] = (T) (Float) (matrix.matrix[j][r].floatValue() - multiple * matrix.matrix[i][r].floatValue());

                }
            }
            for (int i = n - 1; i >= 0; i--) {
                float sum = 0;
                for (int j = i + 1; j < n; j++) {
                    sum += matrix.matrix[i][j].floatValue() * resultVector.matrix[j][0].floatValue();
                }
                resultVector.matrix[i][0] = (T) (Float) ((vector.matrix[i][0].floatValue() - sum) / matrix.matrix[i][i].floatValue());
            }

            for (int i = 0; i < n; i++) {
                float sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += MatrixCopy.matrix[i][j].floatValue() * resultVector.matrix[j][0].floatValue();

                }
                checkingVector.matrix[i][0] = (T) (Float) (sum);
            }

       //    resultVector.printMatrix();
        }
        else if (type.equals(Double.class)){
            double multiple ;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    multiple = matrix.matrix[j][i].doubleValue() / matrix.matrix[i][i].doubleValue();
                    vector.matrix[j][0] = (T) (Double) (vector.matrix[j][0].doubleValue() - multiple * vector.matrix[i][0].doubleValue());
                    for (int r = i; r < n; r++)
                        matrix.matrix[j][r] = (T) (Double) (matrix.matrix[j][r].doubleValue() - multiple * matrix.matrix[i][r].doubleValue());

                }
            }
            for (int i = n - 1; i >= 0; i--) {
                double sum = 0;
                for (int j = i + 1; j < n; j++) {
                    sum += matrix.matrix[i][j].doubleValue() * resultVector.matrix[j][0].doubleValue();
                }
                resultVector.matrix[i][0] = (T) (Double) ((vector.matrix[i][0].doubleValue() - sum) / matrix.matrix[i][i].doubleValue());
            }

            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += MatrixCopy.matrix[i][j].doubleValue() * resultVector.matrix[j][0].doubleValue();

                }
                checkingVector.matrix[i][0] = (T) (Double) (sum);
            }


        }
        return checkingVector;
    }
}
