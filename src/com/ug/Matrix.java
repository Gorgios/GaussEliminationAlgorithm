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

    public void elimination(Matrix<T> matrix, Matrix<T> vector, int i) {
        int n = vector.rows;
        if (type.equals(Float.class)) {
            float multiple;
                for (int j = i + 1; j < n; j++) {
                    multiple = matrix.matrix[j][i].floatValue() / matrix.matrix[i][i].floatValue();
                    vector.matrix[j][0] = (T) (Float) (vector.matrix[j][0].floatValue() - multiple * vector.matrix[i][0].floatValue());
                    for (int r = i; r < n; r++)
                        matrix.matrix[j][r] = (T) (Float) (matrix.matrix[j][r].floatValue() - multiple * matrix.matrix[i][r].floatValue());

            }
        } else if (type.equals(Double.class)) {
            double multiple;
                for (int j = i + 1; j < n; j++) {
                    multiple = matrix.matrix[j][i].doubleValue() / matrix.matrix[i][i].doubleValue();
                    vector.matrix[j][0] = (T) (Double) (vector.matrix[j][0].doubleValue() - multiple * vector.matrix[i][0].doubleValue());
                    for (int r = i; r < n; r++)
                        matrix.matrix[j][r] = (T) (Double) (matrix.matrix[j][r].doubleValue() - multiple * matrix.matrix[i][r].doubleValue());

                }
        }
    }

    public Matrix<T> resultVector(Matrix<T> matrix, Matrix<T> resultVector,Matrix<T> vector){
        int n = vector.rows;
        if (type.equals(Float.class)) {
           for (int i = n - 1; i >= 0; i--) {
               float sum = 0;
               for (int j = i + 1; j < n; j++) {
                   sum += matrix.matrix[i][j].floatValue() * resultVector.matrix[j][0].floatValue();
               }
               resultVector.matrix[i][0] = (T) (Float) ((vector.matrix[i][0].floatValue() - sum) / matrix.matrix[i][i].floatValue());
           }
       }
        else if (type.equals(Double.class)){
           for (int i = n - 1; i >= 0; i--) {
               double sum = 0;
               for (int j = i + 1; j < n; j++) {
                   sum += matrix.matrix[i][j].doubleValue() * resultVector.matrix[j][0].doubleValue();
               }
               resultVector.matrix[i][0] = (T) (Double) ((vector.matrix[i][0].doubleValue() - sum) / matrix.matrix[i][i].doubleValue());
           }

       }
        return resultVector;
    }
    public Matrix<T> checkVector(Matrix<T> matrixCopy, Matrix<T> resultVector,Matrix<T> checkingVector,Matrix<T> vector){
        int n = vector.rows;
        if (type.equals(Float.class)) {
            for (int i = 0; i < n; i++) {
                float sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += matrixCopy.matrix[i][j].floatValue() * resultVector.matrix[j][0].floatValue();

                }
                checkingVector.matrix[i][0] = (T) (Float) (sum);
            }
        }
        else if (type.equals(Double.class)){
            for (int i = 0; i < n; i++) {
                double sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += matrixCopy.matrix[i][j].doubleValue() * resultVector.matrix[j][0].doubleValue();

                }
                checkingVector.matrix[i][0] = (T) (Double) (sum);
            }
        }
        return checkingVector;
    }
    public void switchMatrix(Matrix<T> matrix,Matrix<T> vector,int max, int i){
        for (int j = 0; j < matrix.columns; j++) {
            T temp = matrix.matrix[i][j];
            matrix.matrix[i][j] = matrix.matrix[max][j];
            matrix.matrix[max][j] = temp;
        }
        T temp = vector.matrix[i][0];
        vector.matrix[i][0] = vector.matrix[max][0];
        vector.matrix[max][0] = temp;
    }
    public Matrix<T> methodWithoutChoice(Matrix<T> matrix, Matrix<T> vector, Matrix<T> MatrixCopy) {
        int n = vector.rows;
        Matrix<T> resultVector = new Matrix(n, type);
        Matrix<T> checkingVector = new Matrix(n, type);
        for (int i=0; i<n; i++)
            elimination(matrix,vector,i);
        resultVector=resultVector(matrix,resultVector,vector);
       // resultVector.printMatrix();
        checkingVector = checkVector(MatrixCopy,resultVector,checkingVector,vector);

        return checkingVector;
    }

    public Matrix<T> methodWithPartialChoice(Matrix<T> matrix, Matrix<T> vector, Matrix<T> MatrixCopy) {
        int n = vector.rows;
        Matrix<T> resultVector = new Matrix(n, type);
        Matrix<T> checkingVector = new Matrix(n, type);
        if (type.equals(Float.class)) {
            int max;
            for (int i = 0; i < n; i++) {
                max = i;
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(matrix.matrix[j][i].floatValue()) > Math.abs(matrix.matrix[max][i].floatValue())) {
                        max = j;
                    }
                }
                switchMatrix(matrix, vector, max, i);
                elimination(matrix, vector,i);
            }
        }
        if (type.equals(Double.class)) {
            int max;
            for (int i = 0; i < n; i++) {
                max = i;
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(matrix.matrix[j][i].doubleValue()) > Math.abs(matrix.matrix[max][i].doubleValue())) {
                        max = j;
                    }
                }
                switchMatrix(matrix, vector, max, i);
                elimination(matrix, vector,i);
            }
        }
        resultVector = resultVector(matrix, resultVector, vector);
       // resultVector.printMatrix();
        checkingVector = checkVector(MatrixCopy, resultVector, checkingVector, vector);
        return checkingVector; }

    public void printMatrix() {
        System.out.println("MACIERZ: ");
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++)
                System.out.print(matrix[j][i] + "  ");
            System.out.print("\n");
        }
    }
}
