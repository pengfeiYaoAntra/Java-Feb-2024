package com.training.demo;

import java.io.File;
import java.lang.reflect.Field;
import java.util.*;

/*
    *
    * Java collections
    *  resize method for each collection, time complexity for each functions in collections
    *
    * Arraylist
    * what is diff between arraylist and array
    *   the size of array is fixed after initializing, and arraylist is variable length
    *
    * random access: supports fast access and retrieve any element
    *       1 m data in your arraylist -> the time cost you access 1st element = the time cost  999999 element
    *resizing in array list
    *when you are adding the first element in the list -> elementData.length = 0 ->
    * this if statement is true, we go to grow method -> elemeentData.length = 10
    *  if (minCapacity > elementData.length
            && !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
                 && minCapacity <= DEFAULT_CAPACITY)) {
            modCount++;
            grow(minCapacity);
        }
        * add 2nd, 3, 4... elementData.length = 10
        *
        * add 10th -> elementData.length = 1.5 * old capacity
        *
        * time complexity in arraylist
        * add -> worst case: O(n) -> we need copy all elements into a new array, O(1)
        * add(index, element) ->O(N)
        * remove ->O(N)
        * get() -> O(1)
        * indexOf ->O(N)
        * contains ->O(N)
        * \
        * vector + stack = first in last out data structure
        * stack + vector -> synchronization to achieve thread safe, this is inefficient in the single-thread enviroment
        * stack extends vector
        * vector implements random access
        * private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = ArraysSupport.newLength(oldCapacity,
                minCapacity - oldCapacity,
                capacityIncrement > 0 ? capacityIncrement : oldCapacity);
                        return elementData = Arrays.copyOf(elementData, newCapacity);
                               }
                               *
                               *
        * stack + vector: if you donot give capacityIncrement, the resize mechanism is 2 * old
        * stack + vector: if you give capacityIncrement, the resize mechanism is old + capacityIncrement
        * TC in stack
        * push O(1)
        * pop O(1)
        * size O(1)
        * TC in vector
        * add O(1)
        * remove O(1)
        * size  O(1)
        *
        *
    *linkedlist + deque
    * Linkedlist -> uses double linked list data structure
    * does not support random access, not thread safe
    *  add function in linked list
    * public boolean add(E e) {
        linkLast(e);
        return true;
    }
    *  void linkLast(E e) {
    *   // remeber the current last node -> l
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);// creating new node and the previous node is l
        last = newNode;// last node points to new node
        if (l == null)// there is no element in your linked list
            first = newNode;
        else // there has element(s) in your linked list-> the next of node l points to new node
            l.next = newNode; -> node1 <-> node2 <-> node3
        size++;
        modCount++;
    }
    * TC in linked list
    * Add() O(1)
    * add(index, element) O(N)
    * get() O(N)
    * remove O(N)
    *
    * deque is double ended queue, FILO and FIFO
    *
    * queue methods    equivalent deque method
    *
    * offer -> offerlast
    * poll() -> pollfirst
    * add() -> addLast
    * peek() -> peekFirst()
    *
    * stack methods
    *  push(e) -> addFirst(e)
    *
    * pop()  -> removeFirst
    * peek -> getFirst()
    *
    *
    *
    * Queue
    *
    *  it uses array as data structure ->
    *
    *                   3
    *               /      \
    *           5           10
    *       /   \           /   \
    *   7       9       15     11
    * /\        /
    * 13 20  12
    * leftNodeIndex = parentNodeIndex * 2 +1
    * rightNodeIndex = parentNOdeIndex * 2 + 2
    * parentIndex = (node index -1)/2
    *
    * min heap ->  you can remove the lowest weight element
    * cannot have null value in priorityqueue because:
    * if (e == null)
            throw new NullPointerException();
    *
    *
    * HashMap
    * it is using array(bucket) + linked list or red-black tree
    * in hashmap, we could have null value, but we can have only one null value
    * hashing in hashmap
    * first step: static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
             }
    * final step: ((p = tab[i = (n - 1) & hash]) == null)
    *  ^ : XOR
    * >>> : ;shit right
    * h = key.hashCode() -> 1111 1111 1111 1111 1111 0000 1110 1010
    *   (h >>> 16) ->       0000 0000 0000 0000 1111 1111 1111 1111
    * XOR - >               1111 1111 1111 1111 0000 1111 0001 0101
    * (n - 1) & hash]->     0000 0000 0000 0000 0000 0000 0000 1111
    *                       0000 0000 0000 0000 0000 0000 0000 0101
    *    i =    (n - 1) & hash = 0101 -> 5 it is index
    *
    *  final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        * // one or more elements added into hashmap
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            * oldCap shits to left = oldcap * 2 = new cap
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
    * when hashmap change data structure from linked list to red-black tree
    *   when the len of linked list is greater 8
    *
    * when hashmap change data structure from red-black tree to linked
    * when the len of red-black tree is less than 6
    *
    *
    * treemap -> ordered
    *
    * set and treeset
    *
    * hashset   vs tree set
    * hash table, red-black tree
    * O(1)          O(logN)
    * arbitrary        sorted
    * faster        slower
    * allow null    not allow
    *
    *
    *
    *
    *
    *
 */
public class JavaBasicDayTwo {
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        //empty list
        System.out.println(getCapacity(list));// 0
        //adding the first element to list
        list.add(1);
        System.out.println(getCapacity(list));//10

        List<Integer> synchronizedList = Collections.synchronizedList(list);

        Deque<String> deque   = new LinkedList<>();
        deque.addFirst("apple");
        deque.addLast("banana");
        String first = deque.removeFirst();
        String last = deque.removeLast();
        deque.addFirst("apple");
        deque.addLast("banana");
        for(String s : deque){

        }

        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()){
            String e = iterator.next();
            System.out.println(e);
        }
        //peek() to check the element and donot delete it



        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(100);
        int min = minHeap.poll();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        max.add(3);
        max.add(1);
        max.add(100);
        int maxV = max.poll();
        //HashMap

    }
    static int getCapacity(List list) throws Exception{
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return((Object[]) field.get(list)).length;
    }
}
