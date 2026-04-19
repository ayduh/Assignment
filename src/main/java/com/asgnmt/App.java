package com.asgnmt;

public class App{
    public static void main( String[] args ){
        int[] array = new int[3];

        for(int i = 0; i < 3; i++){
            array[i] = i;
        }

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        for(int i = 2; i > 0; i--){array[i] = array[i-1];}

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

    }
}
