package com.wzl.structure.linked;


public class SingleLinkedList<E> {
    private Node head;
    private Node tail;

    public SingleLinkedList() {
        head = null;
    }

    public boolean add(E e) {
        Node node = new Node();
        node.data = e;
        node.next = null;
        if (head == null) {
            this.head = node;
            return true;
        }
        if (tail == null) {
            tail = node;
            head.next = tail;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public boolean remove(E e) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        if (e == head.data) {
            Node newNode = head.next;
            head.next = null;
            head = newNode;
            return true;
        }
        Node pre;
        Node node = head;
        while (node.next != null) {
            pre = node;
            Node next = node.next;
            if (e == node.next.data) {
                if (node.next == tail) {
                    tail = pre;
                }
                pre.next = next.next;
                next.next = null;
                return true;
            }
        }
        return false;
    }

    private class Node {
        private Object data;
        private Node next;
    }


    public static void main(String[] args) {
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        System.out.println(singleLinkedList);
        singleLinkedList.remove(2);
        System.out.println(singleLinkedList);
    }
}
