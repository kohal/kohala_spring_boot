package com.reflex.service;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: xuyongjian
 * @Date: 2017/9/18
 */
public class QuickSortDemo {


    public static void main(String[] args) {
        int[] a = {6, 8, 12, 4, 9, 20, 5, 7, 2, 10};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);

        if (index > left)
            quickSort(arr, left, index);

        if (index + 1 < right)
            quickSort(arr, index + 1, right);
    }

    static int partition(int[] arr, int left, int right) {
        int i = left, j = left + 1;
        int ind = left+new Random().nextInt(right - left);
        swap(arr, left, ind);
        int pivot = arr[left];
        while (j <= right) {
            if (arr[j] < pivot) {
                swap(arr, i + 1, j);
                i++;
                j++;
            } else j++;

        }
        swap(arr, left, i);
        return i;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
