package Sorting;

public class MergeSort {
    private static void merge(int[] arr , int left , int right , int mid) {
        int temp[] = new int[right-left+1];
        int k=0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j<= right) {
            if (arr[i] >= arr[j]) {
                temp[k] =  arr[j];
                j++;
                k++;
            } else {
                temp[k] = arr[i];
                i++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }
    public static void mergeSort(int[] arr , int left  , int right) {

        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr , left , mid);
        mergeSort(arr , mid + 1 , right);
        merge(arr , left , right , mid);
    }
    public static void main(String[] args) {
        int[] arr = {10 , 9 , 8 , 7 , 6 , 5};
        MergeSort.mergeSort(arr , 0 , arr.length-1);
        for (int i : arr) {
            System.out.println(i + " ");
        }

    }
}
