package com.asgnmt;

public class MyArrayList<T> implements MyListInter<T>{
    private Object[] array;
    private int size = 0;
    private int capacity = 6;

    public MyArrayList() {array = new Object[capacity];}

    private void addSpace(){
        capacity *= 1.5;
        Object[] newArray = new Object[capacity];

        for(int i = 0; i < size; i++){newArray[i] = array[i];}
        array = newArray;
    }

    // Adds an element to the end. If the array is full, calls addSpace(), 
    // places the item at array[size], and increments size
    @Override
    public void add(T item){
        if(size == capacity){addSpace();}
        array[size++] = item;
    }
    
    //Same as the add method
    @Override
    public void addLast(T item){
        if(size == capacity){addSpace();}
        array[size++] = item;
    }

    // Validates the insertion index, resizes if needed, 
    // shifts all elements from after index one position to the right, 
    // inserts the new item and increments size
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {throw new IndexOutOfBoundsException();}

        if (size == capacity) {addSpace();}

        for (int i = size; i > index; i--) {array[i] = array[i - 1];}

        array[index] = item;
        size++;
    }

    // Replaces the element at the specified index. Checks bounds and directly assigns the new value
    @Override
    public void set(int index, T item){
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException();}

        array[index] = item;
    };

    // shifts every existing element one position to the right, and places the new item at index 0
    @Override
    public void addFirst(T item){
        if (size == capacity) {addSpace();}

        for (int i = size; i > 0; i--) {array[i] = array[i - 1];}

        array[0] = item;
        size++;
    }


    // Returns the element at the given index after bounds checking. Casts Object to T
    @Override
    public T get(int index){
        if(index < 0 || index >= size){throw new IndexOutOfBoundsException();}

        return (T) array[index];
    }

    // Return the first element
    // Throw IndexOutOfBoundsException if the list is empty
    @Override
    public T getFirst(){
        if(size == 0){throw new IndexOutOfBoundsException();}

        return (T) array[0];
    }

    // Return the last element
    // Throw IndexOutOfBoundsException if the list is empty
    @Override
    public T getLast(){
        if(size == 0){throw new IndexOutOfBoundsException();}

        return (T) array[size - 1];
    }

    // Checks bounds, shifts all elements after index one position left to fill the gap
    // nulls out the appeard duplicate last slot, and decrements size
    @Override
    public void remove(int index){
        if(index < 0 || index >= size){throw new IndexOutOfBoundsException();}

        for(int i = index; i < size - 1; i++){array[i] = array[i + 1];}
        array[--size] = null;
    }

    // Removes first element
    @Override
    public void removeFirst(){
        if(size == 0){throw new IndexOutOfBoundsException();}
        remove(0);
    }

    // Removes last element
    @Override
    public void removeLast(){
        if(size == 0){throw new IndexOutOfBoundsException();}
        array[--size] = null;
    }


    // Implements Selection Sort. Iterates through the list, finds the smallest element in the unsorted part, 
    // and swaps it into place. Casts elements to Comparable
    @Override
    public void sort(){
        for(int i = 0; i < size - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < size; j++){
                if(((Comparable) array[j]).compareTo(array[minIndex]) < 0){minIndex = j;}
            }

            Object t = array[i]; 
            array[i] = array[minIndex];
            array[minIndex] = t;
        }
    }

    //Scans forward for the first match. Uses null-safe comparison
    //and returns the index
    @Override
    public int indexOf(Object object){
        for(int i = 0; i < size; i++){
            if(object == null ? array[i] == null : object.equals(array[i])){return i;}
        }
        return -1;
    }

    // Same but scans backward and find last match
    @Override
    public int lastIndexOf(Object object){
        for(int i = size - 1; i >= 0; i--){
            if(object == null ? array[i] == null : object.equals(array[i])){return i;}
        }
        return -1;
    }

    //Checks if an element is present by verifying indexOf() != -1
    @Override
    public boolean exists(Object object){
        return indexOf(object) != -1;
    }

    // Creates a fresh Object[] of exact length size,
    // copies the valid elements, and returns it
    @Override
    public Object[] toArray(){
        Object[] res = new Object[size];
        for(int i = 0; i < size; i++){res[i] = array[i];}
        return res;
    }

    // Iterates through valid indexes, sets each reference to null,
    // and resets size to 0
    @Override
    public void clear(){
        for(int i = 0; i < size; i++){array[i] = null;}
        size = 0;
    }

    // Returns the current number of stored elements (not the array's total capacity)
    @Override
    public int size(){
        return size;
    }
}
