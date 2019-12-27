package com.wzl.structure.array;

import sun.misc.BASE64Decoder;

import java.util.function.ToIntFunction;

/**
 * 有序数组
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191227 10:56:22
 */
public class SortedArray<E extends Comparable> {

    private int size;

    private int capacity;

    private Object[] array;

    public SortedArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = new Object[capacity];
    }

    public boolean add(E e) {
        if (size == capacity) {
            grew();
        }
        if (size == 0) {
            array[size++] = e;
            return true;
        }
        int index = size;
        for (int i = 0; i < size; i++) {
            if (e.compareTo(array[i]) < 0) {
                index = i;
                break;
            }
        }
        if (index == 0) {
            size++;
            array[index] = e;
            return true;
        }
        for (int j = size + 1; j > index; j--) {
            array[j] = array[j - 1];
        }
        size++;
        array[index] = e;
        return true;
    }

    public boolean remove(E e) {
        int index = indexOf(e);
        if (index == -1) {
            return false;
        }
        if (index == size - 1) {
            array[index] = null;
            size--;
            return true;
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    private void grew() {
        Object[] array = new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            array[i] = this.array[i];
        }
        this.array = array;
    }

    public E get(int i) {
        return (E) array[i];
    }

    private int size() {
        return size;
    }

    public static void main(String[] args) {
        SortedArray sortedArray = new SortedArray(10);
        sortedArray.add(1);
        sortedArray.add(4);
        sortedArray.add(2);
        sortedArray.add(9);
        for (int i = 0; i < sortedArray.size(); i++) {
            System.out.println(sortedArray.get(i));
        }
    }
}
