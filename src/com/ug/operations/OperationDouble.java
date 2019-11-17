package com.ug.operations;

public class OperationDouble implements Operations<Double> {
    @Override
    public int compare(Double a, Double b) {
        if (a > b)
            return 1;
        else if (a < b)
            return -1;
        return 0;
    }

    @Override
    public Double sub(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double sum(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a/b;
    }

    @Override
    public Double divide(Double a, int b) {
        return a/b;
    }

    @Override
    public Double divide(int a, int b){
        return (double) a/b;
    }

    @Override
    public Double changeSign(Double a) {
        return a * (-1);
    }


    @Override
    public Double abs(Double a) {
        return Math.abs(a);
    }

    @Override
    public Double[] initializeArray(int size) {
        return new Double[size];
    }

    @Override
    public Double[][] initialize2DArray(int rows,int columns) {
        return new Double[rows][columns];
    }

    @Override
    public Double initializeEmptyVariable() {
        return 0.0;
    }
}
