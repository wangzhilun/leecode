package com.wzl.structure.array;

/**
 * 归并排序
 *
 * @author zhilun.wang @ximalaya.com
 * @date 20191225 10:28:37
 */
public class MergeSortArray {

    public static void main(String[] args) {
        int[] ans = {6, 8, 4, 4, 6, 36, 673, 13, 6, 7, 3, 4, 6, 8, 3, 7, 5, 7, 9, 5};
        System.out.print("原数组：");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println();
        mergeSort(ans, 0, ans.length - 1);
        System.out.print("归并排序之后的数组：");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ",");
        }
    }

    public static void mergeSort(int[] ints, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = (tail + head) / 2;
        mergeSort(ints, head, mid);
        mergeSort(ints, mid + 1, tail);
        mergeSort(ints, head, mid, tail);
    }

    public static void mergeSort(int[] ints, int head, int mid, int tail) {
        int headIndex = head;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        int[] temp = new int[tail - head + 1];
        while (headIndex <= mid && rightIndex <= tail) {
            if (ints[headIndex] <= ints[rightIndex]) {
                temp[tempIndex] = ints[headIndex];
                headIndex++;
            } else {
                temp[tempIndex] = ints[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        while (headIndex <= mid) {
            temp[tempIndex] = ints[headIndex];
            tempIndex++;
            headIndex++;
        }
        while (rightIndex <= tail) {
            temp[tempIndex] = ints[rightIndex];
            tempIndex++;
            rightIndex++;
        }
        for (int i = 0; i < temp.length; i++) {
            ints[head] = temp[i];
            head++;
        }
    }
}
