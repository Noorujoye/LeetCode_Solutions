package Sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void mergeArrays (int arr1[] ,int arr2[]) {
        int i = arr1.length-1 , j = 0;

        while (i >= 0 && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int p=0; p<arr1.length; p++) {
            System.out.print(arr1[p] +",");
        }
        System.out.println();
        for (int p=0; p<arr2.length; p++) {
            System.out.print(arr2[p] +",");
        }
    }
    public static void main(String[] args) {

        int arr1[] = {1,2,5,4,5,10};
        int arr2[] = {1,3,4,5};
        mergeArrays(arr1,arr2);
    }
}
