package com.ug;

import com.ug.operations.OperationDouble;
import com.ug.operations.OperationFloat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
     int size = 500;
     ErrorCounter<Double> errDb = new ErrorCounter<>(new OperationDouble());
     ErrorCounter<Float> errFl = new ErrorCounter<>(new OperationFloat());
        List<List<String>> errorCounter = new ArrayList<>();
        List<List<String>> timeCounter = new ArrayList<>();
        timeCounter.add(Arrays.asList("Size","FloatW","DoubleW","FloatP","DoubleP","FloatF","DoubleF"));
        errorCounter.add(Arrays.asList("Size","FloatW","DoubleW","FloatP","DoubleP","FloatF","DoubleF"));
        RandomGenerator intMatrix[][];
        RandomGenerator intVector[][];
        Matrix <Float> matrixFloat ;
        Matrix <Float> matrixCopyFloat ;
        Matrix <Float> vectorFloat  ;
        Matrix <Float> vectorCopyFloat ;
        Matrix <Float> vectorCheckFloat;
        Matrix <Double> matrixDouble;
        Matrix <Double>  matrixCopyDouble;
        Matrix <Double> vectorDouble;
        Matrix <Double> vectorCopyDouble;
        Matrix <Double>  vectorCheckDouble;
        for (int i=100;i<=size;i+=100){
            intMatrix=RandomGenerator.generateMatrix(i);
            intVector=RandomGenerator.generateVector(i);
            //Without Choice
            //Float
            matrixFloat = new Matrix<Float>(i,i,intMatrix,new OperationFloat());
            matrixCopyFloat = new Matrix<Float>(i,i,intMatrix,new OperationFloat());
            vectorFloat = new Matrix<Float>(1,i,intVector,new OperationFloat());
            vectorCopyFloat = new Matrix<Float>(1,i,intVector,new OperationFloat());
            matrixFloat.generateMatrix();
            matrixCopyFloat.generateMatrix();
            vectorFloat.generateMatrix();
            vectorCopyFloat.generateMatrix();
            //Double
            matrixDouble = new Matrix<Double>(i,i,intMatrix,new OperationDouble());
            matrixCopyDouble = new Matrix<Double>(i,i,intMatrix,new OperationDouble());
            vectorDouble = new Matrix<Double>(1,i,intVector,new OperationDouble());
            vectorCopyDouble = new Matrix<Double>(1,i,intVector,new OperationDouble());
            matrixDouble.generateMatrix();
            matrixCopyDouble.generateMatrix();
            vectorDouble.generateMatrix();
            vectorCopyDouble.generateMatrix();
           // matrixDouble.printMatrix();
            long startFloatW = System.currentTimeMillis();
            vectorCheckFloat= matrixFloat.methodWithoutChoice(matrixFloat,vectorFloat,matrixCopyFloat);
            long timeFloatW = System.currentTimeMillis()-startFloatW;
            long startDoubleW = System.currentTimeMillis();
            vectorCheckDouble= matrixDouble.methodWithoutChoice(matrixDouble,vectorDouble,matrixCopyDouble);
            long timeDoubleW = System.currentTimeMillis()-startDoubleW;
            Float errFloatW = errFl.countError(vectorCopyFloat,vectorCheckFloat,i);
            Double errDoubleW =errDb.countError(vectorCopyDouble,vectorCheckDouble,i);

            //Partial Choice
            //Float

            matrixFloat = new Matrix<Float>(i,i,intMatrix,new OperationFloat());
            matrixCopyFloat = new Matrix<Float>(i,i,intMatrix,new OperationFloat());
            vectorFloat = new Matrix<Float>(1,i,intVector,new OperationFloat());
            vectorCopyFloat = new Matrix<Float>(1,i,intVector,new OperationFloat());
            matrixFloat.generateMatrix();
            matrixCopyFloat.generateMatrix();
            vectorFloat.generateMatrix();
            vectorCopyFloat.generateMatrix();
            //Double
            matrixDouble = new Matrix<Double>(i,i,intMatrix,new OperationDouble());
            matrixCopyDouble = new Matrix<Double>(i,i,intMatrix,new OperationDouble());
            vectorDouble = new Matrix<Double>(1,i,intVector,new OperationDouble());
            vectorCopyDouble = new Matrix<Double>(1,i,intVector,new OperationDouble());
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
            float errFloatP = errFl.countError(vectorCopyFloat,vectorCheckFloat,i);
            double errDoubleP =errDb.countError(vectorCopyDouble,vectorCheckDouble,i);
            //FUll Choice
            //Float

            matrixFloat = new Matrix<Float>(i,i,intMatrix,new OperationFloat());
            matrixCopyFloat = new Matrix<Float>(i,i,intMatrix,new OperationFloat());
            vectorFloat = new Matrix<Float>(1,i,intVector,new OperationFloat());
            vectorCopyFloat = new Matrix<Float>(1,i,intVector,new OperationFloat());
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

            matrixDouble = new Matrix<Double>(i,i,intMatrix,new OperationDouble());
            matrixCopyDouble = new Matrix<Double>(i,i,intMatrix,new OperationDouble());
            vectorDouble = new Matrix<Double>(1,i,intVector,new OperationDouble());
            vectorCopyDouble = new Matrix<Double>(1,i,intVector,new OperationDouble());
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
            float errFloatF = errFl.countError(vectorCopyFloat,vectorCheckFloat,i);
            double errDoubleF =errDb.countError(vectorCopyDouble,vectorCheckDouble,i);
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
