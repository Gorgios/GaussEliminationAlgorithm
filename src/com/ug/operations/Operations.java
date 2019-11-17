package com.ug.operations;

public interface Operations<T> {
    int compare(T a, T b);

    T sub(T a, T b);

    T sum(T a, T b);

    T multiply(T a, T b);

    T divide(T a, T b);

    T divide(T a, int b);

    T divide(int a, int b);

    T changeSign(T a);

    T abs(T a);

    T[] initializeArray(int size);

    T[][] initialize2DArray(int rows, int columns);

    T initializeEmptyVariable();

}

