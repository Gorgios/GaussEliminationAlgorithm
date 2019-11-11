package com.ug;

public class Main {

    public static void main(String[] args) {
       int size = 10;
       RandomGenerator intMatrix[][];
       RandomGenerator intVector[][];
       intMatrix=RandomGenerator.generateMatrix(size);
       intVector=RandomGenerator.generateVector(size);
        //float
       Matrix matrixF = new Matrix(size,size,Float.class,intMatrix);
       Matrix matrixCopyF = new Matrix(size,size,Float.class,intMatrix);
       Matrix vectorF = new Matrix(1,size,Float.class,intVector);
       Matrix vectorCopyF = new Matrix(1,size,Float.class,intVector);
       Matrix vectorCheckF;
        //double

        Matrix matrixD = new Matrix(size,size,Double.class,intMatrix);
        Matrix matrixCopyD = new Matrix(size,size,Double.class,intMatrix);
        Matrix vectorD = new Matrix(1,size,Double.class,intVector);
        Matrix vectorCopyD = new Matrix(1,size,Double.class,intVector);
        Matrix vectorCheckD;

        matrixF.generateMatrix();
        matrixCopyF.generateMatrix();
        vectorF.generateMatrix();
        vectorCopyF.generateMatrix();

       matrixD.generateMatrix();
       matrixCopyD.generateMatrix();
       vectorD.generateMatrix();
       vectorCopyD.generateMatrix();

       vectorCheckF= matrixF.methodWithoutChoice(matrixF,vectorF,matrixCopyF);
        System.out.println(ErrorCounter.floatError(vectorCopyF,vectorCheckF,size));
        matrixF = new Matrix(size,size,Float.class,intMatrix);
        matrixCopyF = new Matrix(size,size,Float.class,intMatrix);
        vectorF = new Matrix(1,size,Float.class,intVector);
        vectorCopyF = new Matrix(1,size,Float.class,intVector);
        matrixF.generateMatrix();
        matrixCopyF.generateMatrix();
        vectorF.generateMatrix();
        vectorCopyF.generateMatrix();
        vectorCheckF= matrixF.methodWithPartialChoice(matrixF,vectorF,matrixCopyF);
        vectorCheckD= matrixD.methodWithPartialChoice(matrixD,vectorD,matrixCopyD);

      //  vectorCopyF.printMatrix();
     //   vectorCheckF.printMatrix();
       System.out.println(ErrorCounter.floatError(vectorCopyF,vectorCheckF,size));
       System.out.println(ErrorCounter.doubleError(vectorCopyD,vectorCheckD,size));
       //System.out.println(Tests.isMatrixOk(4000));
    }
}
