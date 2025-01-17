package in.co.codeWithMayank.c100_c199;

import java.util.*;

public class c146_tcNsc_sort01Array {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        sort01Array(arr);
        printArray(arr);
    }

    // use concept of partioning of Array
    // assume pivot to be 0
    public static void sort01Array(int[] arr) {
        int i = 0, j = 0;
        while (i < arr.length) {
            if (arr[i] == 1) { // if(arr[i]>0)
                i++;
            } else if (arr[i] == 0) { // else if (arr[i] <= 0)
                swap(arr, i, j);
                i++;
                j++;
            }
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}