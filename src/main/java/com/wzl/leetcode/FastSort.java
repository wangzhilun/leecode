package com.wzl.leetcode;

/**
 * 快速排序
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191225 14:51:55
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] ints, int low, int high) {
        if (low > high) {
            return;
        }
        int lowIndex = low;
        int highIndex = high;
        int mark = ints[low];
        while (lowIndex < highIndex) {
            while (mark < ints[highIndex] && lowIndex < highIndex) {
                highIndex = highIndex - 1;
            }
            while (mark >= ints[lowIndex] && lowIndex < highIndex) {
                lowIndex = lowIndex + 1;
            }
            if (lowIndex < highIndex) {
                int temp = ints[highIndex];
                ints[highIndex] = ints[lowIndex];
                ints[lowIndex] = temp;
            }
        }
        ints[low] = ints[lowIndex];
        ints[lowIndex] = mark;
        sort(ints, low, highIndex - 1);
        sort(ints, highIndex + 1, high);
    }
}
