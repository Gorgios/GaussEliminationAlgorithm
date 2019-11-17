package com.ug.operations;

public class OperationFloat implements Operations<Float> {

    @Override
    public int compare(Float a, Float b) {
        if (a > b)
            return 1;
        else if (a < b)
            return -1;
        return 0;
    }

    @Override
    public Float sub(Float a, Float b) {
        return a - b;
    }

    @Override
    public Float sum(Float a, Float b) {
        return a + b;
    }

    @Override
    public Float multiply(Float a, Float b) {
        return a * b;
    }

    @Override
    public Float divide(Float a, Float b) {
        return a/b;
    }

    @Override
    public Float divide(Float a, int b) {
        return a/b;
    }

    @Override
    public Float divide(int a, int b){
        return (float) a / b;
    }

    @Override
    public Float changeSign(Float a) {
        return a * (-1);
    }

    @Override
    public Float abs(Float a) {
        return Math.abs(a);
    }

    @Override
    public Float[] initializeArray(int size) {
        return new Float[size];
    }

    @Override
    public Float[][] initialize2DArray(int row, int columns) {
        return new Float[row][columns];
    }

    @Override
    public Float initializeEmptyVariable() {
        return 0.0f;
    }
}
