Classes
MyListInter<T> (Interface)
Core interface defining list operations:

  add(T), add(int, T), addFirst(T), addLast(T)
    get(int), getFirst(), getLast(), set(int, T)
    remove(int), removeFirst(), removeLast()
    indexOf(Object), lastIndexOf(Object), exists(Object)
    sort(), toArray(), clear(), size(), iterator()

MyArrayList<T>

  Backing store: Object[] array with dynamic resizing (1.5x growth)
    Key features: 
        O(1) amortized add at end
        O(n) insert/remove at arbitrary index
        Selection sort implementation
        Null-safe element comparison

MyLinkedList<T>

  Structure: Doubly-linked nodes with head and tail references
    Key features:
        O(1) add/remove at both ends
        Bidirectional traversal for indexed access optimization
        Loop prevention via boundary enforcement
        In-place selection sort

MyStack<T>

  Backing structure: MyArrayList<T> (optimal for LIFO operations)
    Operations: push(T), pop(), peek(), isEmpty(), size(), clear()
    Complexity: All operations O(1)

  MyQueue<T>

  Backing structure: MyLinkedList<T> (optimal for FIFO operations)
    Operations:
        enqueue(T): Adds element to end of queue - O(1)
        dequeue(): Removes and returns element from front - O(1)
        peek(): Returns front element without removing - O(1)
        empty(), size(): Status checks - O(1)
    Note: Uses addLast() for enqueue and removeFirst() for dequeue to maintain FIFO order

MyMinHeap<T extends Comparable<T>>

  Backing structure: MyArrayList<T> (required for index-based heap operations)
    Operations:
        insert(T): Adds element and restores heap property - O(log n)
        extractMin(): Removes and returns minimum element - O(log n)
        getMin(): Returns minimum without removing - O(1)
        empty(), size(): Status checks - O(1)
    Heap properties:
        Complete binary tree stored in array
        Parent at index i, children at 2i+1 and 2i+2
        Each node <= its children (min-heap invariant)
    Helper methods: heapify(), traverseUp(), swap(), index calculators
