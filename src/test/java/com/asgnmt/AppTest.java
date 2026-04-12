package com.asgnmt;

public class AppTest{
    public static void main( String[] args ){
        MyArrayList<Integer> b = new MyArrayList();

        b.add(2);
        System.out.println(b.getFirst());
        System.out.println(b.getLast());
    }
}
