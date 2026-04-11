package com.asgnmt;

public class MyArrayList<T>
{
    private Object[] array;
    private int size = 0;
    private int capacity = 6;

    public MyArrayList() {
        array = new Object[capacity];
    }

    public T get(int index){
        return (T) array
    }
}
