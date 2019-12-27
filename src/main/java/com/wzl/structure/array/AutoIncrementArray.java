package com.wzl.structure.array;

/**
 * 动态扩容数组
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191227 10:48:22
 */
public class AutoIncrementArray<E> {
    private int size;

    private int capacity;

    private Object[] array;

    public AutoIncrementArray(int capacity) {
        this.capacity = capacity;
        size = 0;
        array = new Object[capacity];
    }

    public boolean add(E e) {
        if (size == capacity) {
            grew();
        }
        array[size++] = e;
        return true;
    }

    public boolean set(int i, E e) {
        if (i > capacity) {
            throw new IndexOutOfBoundsException();
        }
        while (size == capacity) {
            grew();
        }
        array[i] = e;
        return true;
    }

    public E get(int i) {
        return (E) array[i];
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

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        AutoIncrementArray<Integer> autoIncrementArray = new AutoIncrementArray(2);
        autoIncrementArray.add(1);
        autoIncrementArray.add(2);
        autoIncrementArray.add(3);
        autoIncrementArray.add(4);
        for (int i = 0; i < autoIncrementArray.size(); i++) {
            System.out.println(autoIncrementArray.get(i));
        }
        autoIncrementArray.set(2, 6);
        autoIncrementArray.remove(4);
        for (int i = 0; i < autoIncrementArray.size(); i++) {
            System.out.println(autoIncrementArray.get(i));
        }
    }
}

