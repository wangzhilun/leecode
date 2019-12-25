package com.wzl.leetcode;

/**
 * 二分查找
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191225 16:57:36
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] ints = new int[]{2, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(commonBinarySearch(ints, 2));
        System.out.println(binarySearchFirst(ints, 2));
        System.out.println(binarySearchLast(ints, 2));
    }

    /**
     * 最简单的二分查找
     */
    public static int commonBinarySearch(int[] ints, int i) {
        int right = ints.length - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (ints[mid] == i) {
                return mid;
            }
            if (ints[mid] > i) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个数字
     */
    public static int binarySearchFirst(int[] ints, int i) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (ints[mid] > i) {
                right = mid - 1;
            } else if (ints[mid] < i) {
                left = mid + 1;
            } else {
                if (mid == 0 || ints[mid - 1] != i) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 查找最后一个数字
     */
    public static int binarySearchLast(int[] ints, int i) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (ints[mid] > i) {
                right = mid - 1;
            } else if (ints[mid] < i) {
                left = mid + 1;
            } else {
                if (mid == ints.length - 1 || ints[mid + 1] != i) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
