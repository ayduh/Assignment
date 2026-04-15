package com.asgnmt;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        System.out.println("size: " + list.size());
        System.out.println("isEmpty check via size: " + (list.size() == 0));

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("after add 1,2,3 size: " + list.size());
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(2): " + list.get(2));

        list.addLast(4);
        System.out.println("after addLast(4) getLast: " + list.getLast());

        list.addFirst(0);
        System.out.println("after addFirst(0) getFirst: " + list.getFirst());

        list.add(2, 99);
        System.out.println("after add(2,99) get(2): " + list.get(2));

        list.set(3, 77);
        System.out.println("after set(3,77) get(3): " + list.get(3));

        System.out.println("indexOf(99): " + list.indexOf(99));
        System.out.println("lastIndexOf(2): " + list.lastIndexOf(2));
        System.out.println("exists(77): " + list.exists(77));
        System.out.println("exists(100): " + list.exists(100));

        Object[] arr = list.toArray();
        System.out.print("toArray: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("iterator: ");
        java.util.Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        list.remove(2);
        System.out.println("after remove(2) size: " + list.size() + " get(2): " + list.get(2));

        list.removeFirst();
        System.out.println("after removeFirst getFirst: " + list.getFirst());

        list.removeLast();
        System.out.println("after removeLast getLast: " + list.getLast());

        MyArrayList<Integer> sortList = new MyArrayList<>();
        sortList.add(5);
        sortList.add(1);
        sortList.add(4);
        sortList.add(2);
        sortList.add(3);
        sortList.sort();
        System.out.print("after sort: ");
        for (int i = 0; i < sortList.size(); i++) {
            System.out.print(sortList.get(i) + " ");
        }
        System.out.println();

        list.clear();
        System.out.println("after clear size: " + list.size());

        try {
            list.get(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get on empty threw exception");
        }
    }    
}