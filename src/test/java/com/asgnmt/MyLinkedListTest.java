package com.asgnmt;

public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList<String> list = new MyLinkedList<>();

        //Test size and clear on empty list
        // Expect 0 on both
        System.out.println("1. Initial size: " + list.size());
        list.clear();
        System.out.println("After clear(): " + list.size());

        // Test add, addFirst, addLast
        list.addLast("C");
        list.addFirst("A");
        list.add(1, "B");
        System.out.println("\n2. After addFirst(A), add(1,B), addLast(C): " + list.size() + " elements");
        printList(list); // Expected: [A, B, C]

        // Test getFirst, getLast, get
        // Expect A C B
        System.out.println("\n3. getFirst(): " + list.getFirst());
        System.out.println("   getLast(): " + list.getLast());
        System.out.println("   get(1): " + list.get(1));

        // Test set
        // Expect X
        list.set(1, "X");
        System.out.println("\n4. After set(1, 'X'): " + list.get(1));

        // Test indexOf, lastIndexOf, exists
        // Expect 0 3 true false
        list.addLast("A"); // Now: [A, X, C, A]
        System.out.println("\n5. indexOf('A'): " + list.indexOf("A"));
        System.out.println("   lastIndexOf('A'): " + list.lastIndexOf("A"));
        System.out.println("   exists('C'): " + list.exists("C"));
        System.out.println("   exists('Z'): " + list.exists("Z"));

        // Test toArray
        // Expect A X C A
        Object[] arr = list.toArray();
        System.out.print("\n6. toArray(): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.print("]");

        // Test remove, removeFirst, removeLast
        list.removeFirst(); // [X, C, A]
        list.removeLast();  // [X, C]
        list.remove(1);     // [X]
        // Expect 1 and X
        System.out.println("\n7. After removeFirst, removeLast, remove(1): size=" + list.size());
        System.out.println("   Remaining: " + list.getFirst());

        // Test sort
        MyLinkedList<Integer> intList = new MyLinkedList<>();
        intList.add(5); intList.add(1); intList.add(8); intList.add(3);
        System.out.print("\n8. Before sort: ");
        printList(intList);
        intList.sort();
        System.out.print("After sort:  ");
        printList(intList); // Expected: [1, 3, 5, 8]

        // Test Iterator
        System.out.print("\n9. Iterator test: ");
        java.util.Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // Edge Cases & Exceptions
        System.out.println("\n10. Edge Cases:");
        try { list.get(5); } catch (IndexOutOfBoundsException e) {
            System.out.println("   get(5) correctly threw IndexOutOfBoundsException");
        }
        try { list.removeFirst(); } catch (IllegalStateException e) {
            System.out.println("   removeFirst() on empty list correctly threw IllegalStateException");
        }

        // Null handling test
        // Expect 0 1
        MyLinkedList<String> nullList = new MyLinkedList<>();
        nullList.add(null);
        nullList.add("test");
        System.out.println("\n11. Null handling - indexOf(null): " + nullList.indexOf(null));
        System.out.println("    lastIndexOf('test'): " + nullList.lastIndexOf("test"));
    }

    private static <T> void printList(MyLinkedList<T> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + (i == list.size() - 1 ? "" : ", "));
        }
        System.out.println("]");
    }
}