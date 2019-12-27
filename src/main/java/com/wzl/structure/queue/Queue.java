package com.wzl.structure.queue;

public class Queue<E> {
    private int size;
    private int head;
    private int tail;
    private Object[] queue;

    public Queue(int size) {
        this.size = size;
        head = 0;
        tail = 0;
        queue = new Object[size];
    }

    public boolean add(E e) {
        if ((tail + 1) % size == head) {
            return false;
        }
        queue[tail] = e;
        tail = (tail + 1) % size;
        return true;
    }

    public E peek() {
        if (head == tail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = (E) queue[head];
        head = (head + 1) % size;
        return e;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(10);
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        System.out.println(queue.head);
        System.out.println(queue.tail);
        queue.peek();
        queue.add(10);
        System.out.println(queue.head);
        System.out.println(queue.tail);
        queue.add(11);
    }
}
