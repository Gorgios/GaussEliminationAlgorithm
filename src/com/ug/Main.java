package com.ug;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
       int size = 2400;
        List<List<String>> errorCounter = new ArrayList<>();
        List<List<String>> timeCounter = new ArrayList<>();
        timeCounter.add(Arrays.asList("Size","FloatW","DoubleW","FloatP","DoubleP","FloatF","DoubleF"));
        errorCounter.add(Arrays.asList("Size","FloatW","DoubleW","FloatP","DoubleP","FloatF","DoubleF"));
        RandomGenerator intMatrix[][];
        RandomGenerator intVector[][];
        Matrix matrixFloat ;
        Matrix matrixCopyFloat ;
        Matrix vectorFloat  ;
        Matrix vectorCopyFloat ;
        Matrix vectorCheckFloat;
        Matrix matrixDouble;
        Matrix matrixCopyDouble;
        Matrix vectorDouble;
        Matrix vectorCopyDouble;
        Matrix vectorCheckDouble;
        for (int i=100;i<=size;i+=100){
            intMatrix=RandomGenerator.generateMatrix(i);
            intVector=RandomGenerator.generateVector(i);
            //Without Choice
            //Float
            matrixFloat = new Matrix(i,i,Float.class,intMatrix);
            matrixCopyFloat = new Matrix(i,i,Float.class,intMatrix);
            vectorFloat = new Matrix(1,i,Float.class,intVector);
            vectorCopyFloat = new Matrix(1,i,Float.class,intVector);
            matrixFloat.generateMatrix();
            matrixCopyFloat.generateMatrix();
            vectorFloat.generateMatrix();
            vectorCopyFloat.generateMatrix();
            //Double
            matrixDouble = new Matrix(i,i,Double.class,intMatrix);
            matrixCopyDouble = new Matrix(i,i,Double.class,intMatrix);
            vectorDouble = new Matrix(1,i,Double.class,intVector);
            vectorCopyDouble = new Matrix(1,i,Double.class,intVector);
            matrixDouble.generateMatrix();
            matrixCopyDouble.generateMatrix();
            vectorDouble.generateMatrix();
            vectorCopyDouble.generateMatrix();
            long startFloatW = System.currentTimeMillis();
            vectorCheckFloat= matrixFloat.methodWithoutChoice(matrixFloat,vectorFloat,matrixCopyFloat);
            long timeFloatW = System.currentTimeMillis()-startFloatW;
            long startDoubleW = System.currentTimeMillis();
            vectorCheckDouble= matrixDouble.methodWithoutChoice(matrixDouble,vectorDouble,matrixCopyDouble);
            long timeDoubleW = System.currentTimeMillis()-startDoubleW;
            float errFloatW = ErrorCounter.floatError(vectorCopyFloat,vectorCheckFloat,i);
            double errDoubleW =ErrorCounter.doubleError(vectorCopyDouble,vectorCheckDouble,i);

            //Partial Choice
            //Float
            matrixFloat = new Matrix(i,i,Float.class,intMatrix);
            matrixCopyFloat = new Matrix(i,i,Float.class,intMatrix);
            vectorFloat = new Matrix(1,i,Float.class,intVector);
            vectorCopyFloat = new Matrix(1,i,Float.class,intVector);
            matrixFloat.generateMatrix();
            matrixCopyFloat.generateMatrix();
            vectorFloat.generateMatrix();
            vectorCopyFloat.generateMatrix();
            //Double
            matrixDouble = new Matrix(i,i,Double.class,intMatrix);
            matrixCopyDouble = new Matrix(i,i,Double.class,intMatrix);
            vectorDouble = new Matrix(1,i,Double.class,intVector);
            vectorCopyDouble = new Matrix(1,i,Double.class,intVector);
            matrixDouble.generateMatrix();
            matrixCopyDouble.generateMatrix();
            vectorDouble.generateMatrix();
            vectorCopyDouble.generateMatrix();
            long startFloatP = System.currentTimeMillis();
            vectorCheckFloat= matrixFloat.methodWithPartialChoice(matrixFloat,vectorFloat,matrixCopyFloat);
            long timeFloatP = System.currentTimeMillis()-startFloatP;
            long startDoubleP = System.currentTimeMillis();
            vectorCheckDouble= matrixDouble.methodWithPartialChoice(matrixDouble,vectorDouble,matrixCopyDouble);
            long timeDoubleP = System.currentTimeMillis()-startDoubleP;
            float errFloatP = ErrorCounter.floatError(vectorCopyFloat,vectorCheckFloat,i);
            double errDoubleP =ErrorCounter.doubleError(vectorCopyDouble,vectorCheckDouble,i);
            //FUll Choice
            //Float
            matrixFloat = new Matrix(i,i,Float.class,intMatrix);
            matrixCopyFloat = new Matrix(i,i,Float.class,intMatrix);
            vectorFloat = new Matrix(1,i,Float.class,intVector);
            vectorCopyFloat = new Matrix(1,i,Float.class,intVector);
            matrixFloat.generateMatrix();
            matrixCopyFloat.generateMatrix();
            vectorFloat.generateMatrix();
            vectorCopyFloat.generateMatrix();
          /*
           //For test with WOlfram
            System.out.println("MACIERZ NA KTOREJ DZIALAMY");
            matrixFloat.printMatrix();
            System.out.println("WEKTOR KTORY MA WYJSC");
            vectorFloat.printMatrix();

           */
            //Double
            matrixDouble = new Matrix(i,i,Double.class,intMatrix);
            matrixCopyDouble = new Matrix(i,i,Double.class,intMatrix);
            vectorDouble = new Matrix(1,i,Double.class,intVector);
            vectorCopyDouble = new Matrix(1,i,Double.class,intVector);
            matrixDouble.generateMatrix();
            matrixCopyDouble.generateMatrix();
            vectorDouble.generateMatrix();
            vectorCopyDouble.generateMatrix();
            long startFloatF = System.currentTimeMillis();
            vectorCheckFloat= matrixFloat.methodWithFullChoice(matrixFloat,vectorFloat,matrixCopyFloat);
            long timeFloatF = System.currentTimeMillis()-startFloatF;
            long startDoubleF = System.currentTimeMillis();
            vectorCheckDouble= matrixDouble.methodWithFullChoice(matrixDouble,vectorDouble,matrixCopyDouble);
            long timeDoubleF = System.currentTimeMillis()-startDoubleF;
            float errFloatF = ErrorCounter.floatError(vectorCopyFloat,vectorCheckFloat,i);
            double errDoubleF =ErrorCounter.doubleError(vectorCopyDouble,vectorCheckDouble,i);
            errorCounter.add(Arrays.asList(Integer.toString(i),
                    Float.toString(errFloatW),Double.toString(errDoubleW),
                    Float.toString(errFloatP),Double.toString(errDoubleP),
                    Float.toString(errFloatF),Double.toString(errDoubleF)));
            timeCounter.add(Arrays.asList(Integer.toString(i),Long.toString(timeFloatW),Long.toString(timeDoubleW),
                    Long.toString(timeFloatP),Long.toString(timeDoubleP),
                    Long.toString(timeFloatF),Long.toString(timeDoubleF)));
      }
        Writer.saveToFile(errorCounter,"averageErrors2.csv");
        Writer.saveToFile(timeCounter,"timeOfAlgorithms2.csv");
       //System.out.println(Tests.isMatrixOk(4000));
    }
}
