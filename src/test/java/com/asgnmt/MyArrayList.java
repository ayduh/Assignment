package com.asgnmt;

public class MyArrayList<T> implements MyListInter<T>{
    private Object[] array;
    private int size = 0;
    private int capacity = 6;

    public MyArrayList() {array = new Object[capacity];}

    public void addSpace(){
        capacity *= 1.5;
        Object[] newArray = new Object[capacity];

        for(int i = 0; i < size; i++){newArray[i] = array[i];}
        array = newArray;
    }

    @Override
    public void add(T item){
        if(size == capacity){addSpace();}
        array[size++] = item;
    }

    @Override
    public void addLast(T item){
        if(size == capacity){addSpace();}
        array[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}

        if (size == capacity) {addSpace();}

        for (int i = size; i > index; i--) {array[i] = array[i - 1];}

        array[index] = item;
        size++;
    }

    @Override
    public void set(int index, T item){
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}

        array[index] = item;
    };

    @Override
    public void addFirst(T item){
        if (size == capacity) {addSpace();}

        for (int i = size; i > 0; i--) {array[i] = array[i - 1];}

        array[0] = item;
    }

    @Override
    public T get(int index){
        if(index < 0 || index >= size){throw new IndexOutOfBoundsException();}

        return (T) array[index];
    }

    @Override
    public T getFirst(){
        if(size == 0){throw new IndexOutOfBoundsException();}

        return (T) array[0];
    }

    @Override
    public T getLast(){
        if(size == 0){throw new IndexOutOfBoundsException();}

        return (T) array[size - 1];
    }

    @Override
    public void remove(int index){
        if(index < 0 || index >= size){throw new IndexOutOfBoundsException();}

        for(int i = index; i < size - 1; i++){array[i] = array[i + 1];}
        array[--size] = null;
    }

    @Override
    public void removeFirst(){
        if(size == 0){throw new IndexOutOfBoundsException();}
        remove(0);
    }

    @Override
    public void removeLast(){
        if(size == 0){throw new IndexOutOfBoundsException();}
        array[--size] = null;
    }

    @Override
    public void sort(){
        for(int i = 0; i < size - 1; i++){
            int min = i;
            for(int j = i + 1; j < size; j++){
                if(((Comparable) array[j]).compareTo(array[min]) < 0){min = j;}
            }

            Object t = array[i]; 
            array[i] = array[min]; 
            array[min] = t;
        }
    }

    @Override
    public int indexOf(Object object){
        for(int i = 0; i < size; i++){
            if(object == null ? array[i] == null : object.equals(array[i])){return i;}
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object){
        for(int i = size - 1; i >= 0; i--){
            if(object == null ? array[i] == null : object.equals(array[i])){return i;}
        }
        return -1;
    }

    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray(){
        Object[] res = new Object[size];
        for(int i = 0; i < size; i++){res[i] = array[i];}
        return res;
    }

    @Override
    public void clear(){
        for(int i = 0; i < size; i++){array[i] = null;}
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public java.util.Iterator<T> iterator(){
        return new java.util.Iterator<T>(){
            int c = 0;
            public boolean hasNext(){return c < size;}
            public T next(){return (T) array[c++];}
            public void remove(){throw new UnsupportedOperationException();}
        };
    }
}
