package com.ug;

import com.ug.operations.Operations;

public class ErrorCounter<T> {
    private Operations<T> operations;

    public ErrorCounter(Operations<T> operations) {
        this.operations = operations;
    }

    public T countError(Matrix<T> vectorIn, Matrix<T> vectorOut, int size){
        T err = operations.initializeEmptyVariable();
    //    System.out.println(vectorIn.matrix[0][0] + " " + vectorOut.matrix[0][0]);
        for (int i=0; i<size;i++) {
            err = operations.sum(err, operations.abs(operations.sub( vectorIn.matrix[i][0],  vectorOut.matrix[i][0])));
        //    System.out.println(err);
        }
        return operations.divide(err,size);
    }
}
