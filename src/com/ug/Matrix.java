package com.ug;


import com.ug.operations.Operations;

public class Matrix<T> {
    T[][] matrix;
    private int columns;
    private int rows;
    private RandomGenerator[][] intMatrix;
    Operations<T> op;


    public Matrix(int columns, int rows, RandomGenerator[][] intMatrix, Operations<T> operations) {
        this.op = operations;
        this.columns = columns;
        this.rows = rows;
        this.intMatrix = intMatrix;
        this.matrix = op.initialize2DArray(rows, columns);
    }

    public Matrix(int columns, int rows, Operations<T> operations) {
        this.op = operations;
        this.columns = columns;
        this.rows = rows;
        this.matrix = op.initialize2DArray(rows, columns);
    }

    public Matrix(int rows, Operations<T> operations) {
        this.op = operations;
        this.columns = 1;
        this.rows = rows;
        this.matrix = op.initialize2DArray(rows, 1);
    }

    public void generateMatrix() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = op.divide(intMatrix[i][j].getResult(), intMatrix[i][j].getDivider());

    }

    public void elimination(Matrix<T> matrix, Matrix<T> vector, int i) {
        int n = vector.rows;
        T multiple;
        for (int j = i + 1; j < n; j++) {
            multiple = op.divide(matrix.matrix[j][i], matrix.matrix[i][i]);
            //    System.out.println(multiple);
            vector.matrix[j][0] = op.sub(vector.matrix[j][0], op.multiply(multiple, vector.matrix[i][0]));
            for (int r = i; r < n; r++) {
                matrix.matrix[j][r] = op.sub(matrix.matrix[j][r], op.multiply(multiple, matrix.matrix[i][r]));
                //     System.out.println(matrix.matrix[j][r]);
            }


        }
    }

    public Matrix<T> resultVector(Matrix<T> matrix, Matrix<T> resultVector, Matrix<T> vector) {
        int n = vector.rows;
        T sum;
        // System.out.println(sum);
        for (int i = n - 1; i >= 0; i--) {
            sum = op.initializeEmptyVariable();
            for (int j = i + 1; j < n; j++) {
                sum = op.sum(sum, op.multiply(matrix.matrix[i][j], resultVector.matrix[j][0]));
            }
            resultVector.matrix[i][0] = op.divide(op.sub(vector.matrix[i][0], sum), matrix.matrix[i][i]);
            // System.out.println(resultVector.matrix[i][0]);
        }

        return resultVector;
    }

    public Matrix<T> checkVector(Matrix<T> matrixCopy, Matrix<T> resultVector, Matrix<T> checkingVector, Matrix<T> vector) {
        int n = vector.rows;
        //For test in WOlfram
        resultVector.printMatrix();
        for (int i = 0; i < n; i++) {
            T sum = op.initializeEmptyVariable();
            for (int j = 0; j < n; j++)
                sum = op.sum(sum, op.multiply(matrixCopy.matrix[i][j], resultVector.matrix[j][0]));
            checkingVector.matrix[i][0] = sum;
        }
        return checkingVector;
    }

    public void switchMatrixPart(Matrix<T> matrix, Matrix<T> vector, int max, int i) {
        for (int j = 0; j < matrix.columns; j++) {
            T temp = matrix.matrix[i][j];
            matrix.matrix[i][j] = matrix.matrix[max][j];
            matrix.matrix[max][j] = temp;
        }
        for (int k = 0; k < vector.columns; k++) {
            T temp = vector.matrix[i][k];
            vector.matrix[i][k] = vector.matrix[max][k];
            vector.matrix[max][k] = temp;
        }
    }

    public void switchMatrixFull(Matrix<T> matrix, Matrix<T> vector, int maxRow, int maxColumn, int i) {
        for (int j = 0; j < matrix.rows; j++) {
            T temp = matrix.matrix[i][j];
            matrix.matrix[i][j] = matrix.matrix[maxRow][j];
            matrix.matrix[maxRow][j] = temp;
        }

        for (int j = 0; j < vector.columns; j++) {
            T temp = vector.matrix[i][j];
            vector.matrix[i][j] = vector.matrix[maxRow][j];
            vector.matrix[maxRow][j] = temp;
        }

        for (int j = 0; j < matrix.rows; j++) {
            T temp = matrix.matrix[j][i];
            matrix.matrix[j][i] = matrix.matrix[j][maxColumn];
            matrix.matrix[j][maxColumn] = temp;
        }
    }

    public Matrix<T> methodWithoutChoice(Matrix<T> matrix, Matrix<T> vector, Matrix<T> MatrixCopy) {
        int n = vector.rows;
        Matrix<T> resultVector = new Matrix<T>(n, op);
        Matrix<T> checkingVector = new Matrix<T>(n, op);
        for (int i = 0; i < n; i++)
            elimination(matrix, vector, i);
        resultVector = resultVector(matrix, resultVector, vector);
        // resultVector.printMatrix();
        checkingVector = checkVector(MatrixCopy, resultVector, checkingVector, vector);

        return checkingVector;
    }

    public Matrix<T> methodWithPartialChoice(Matrix<T> matrix, Matrix<T> vector, Matrix<T> MatrixCopy) {
        int n = vector.rows;
        Matrix<T> resultVector = new Matrix<T>(n, op);
        Matrix<T> checkingVector = new Matrix<T>(n, op);
        int max;
        for (int i = 0; i < n; i++) {
            max = i;
            for (int j = i + 1; j < n; j++) {
                if (op.compare(op.abs(matrix.matrix[j][i]), op.abs(matrix.matrix[max][i])) == 1)
                    max = j;
            }
            switchMatrixPart(matrix, vector, max, i);
            elimination(matrix, vector, i);
        }

        resultVector = resultVector(matrix, resultVector, vector);
        // resultVector.printMatrix();
        checkingVector = checkVector(MatrixCopy, resultVector, checkingVector, vector);
        return checkingVector;
    }

    public Matrix<T> methodWithFullChoice(Matrix<T> matrix, Matrix<T> vector, Matrix<T> MatrixCopy) {
        int n = vector.rows;
        Matrix<T> resultVector = new Matrix<T>(n, op);
        Matrix<T> realResultVector = new Matrix<T>(n, op);
        Matrix<T> checkingVector = new Matrix<T>(n, op);
        int[] position;
        position = new int[n];

        for (int j = 0; j < n; j++) {
            position[j] = j;
        }
        for (int i = 0; i < n; i++) {
            int maxRow = i;
            int maxColumn = i;

            for (int j = i; j < matrix.rows; j++) {
                for (int k = i; k < matrix.columns; k++) {
                    if (op.compare(op.abs(matrix.matrix[j][k]), op.abs(matrix.matrix[maxRow][maxColumn])) == 1) {
                        maxRow = j;
                        maxColumn = k;
                    }
                }
            }
            int tempInt = position[i];
            position[i] = position[maxColumn];
            position[maxColumn] = tempInt;
            switchMatrixFull(matrix, vector, maxRow, maxColumn, i);
            elimination(matrix, vector, i);
        }
        resultVector = resultVector(matrix, resultVector, vector);
        for (int j = 0; j < n; j++)
            realResultVector.matrix[position[j]][0] = resultVector.matrix[j][0];


        checkingVector = checkVector(MatrixCopy, realResultVector, checkingVector, vector);
        //   trueResult.printMatrix();
        return checkingVector;
    }

    public void printMatrix() {
        System.out.println("MACIERZ: ");
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++)
                System.out.print(matrix[j][i] + "  ");
            System.out.print("\n");
        }
    }
}
