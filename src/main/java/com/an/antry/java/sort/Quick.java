package com.an.antry.java.sort;

public class Quick {
    static int[] arr = new int[] { 9, 8, 4, 6, 7, 4, 10 };

    public static void main(String[] args) {
        print();
        sort(0, arr.length - 1);
    }

    private static void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    static int partition(int low, int high) {
        int i = low;
        int j = high;
        int pivot = low + (high - low) / 2;
        while (i < j) {
            while (arr[i] < arr[pivot]) {
                i++;
            }
            while (arr[j] > arr[pivot]) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        return pivot;
    }

    static void sort(int low, int high) {
        int pivot = partition(low, high);
        System.out.println("pivot: " + pivot);
        print();
        if (low < pivot - 1) {
            sort(low, pivot - 1);
        }
        if (high > pivot + 1) {
            sort(pivot + 1, high);
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
