package com.asgnmt;

public class Testing {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();

        for(int i = 0; i < 10; i++){array.add(i);}
        for(int i = 0; i < 10; i++){System.out.println(array.get(i));}

        array.add(1, 5);
        for(int i = 0; i < 11; i++){System.out.println(array.get(i));}
        
    }
}
