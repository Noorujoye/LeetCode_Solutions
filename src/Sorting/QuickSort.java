package Sorting;

public class QuickSort {
    private static int partition(int[] arr , int st , int end) {
        int idx = st - 1;
//        int j = st;
        int pivot = arr[end];

        for (int j = st; j<end; j++) {
            if (arr[j] <= pivot) {
                idx++;

                int temp = arr[j];
                arr[j] = arr[idx];
                arr[idx] = temp;
            }
        }
        idx++;
        int temp = arr[end];
        arr[end] = arr[idx];
        arr[idx] = temp;
        return idx;
    }
    public static void quickSort(int[] arr , int st , int end) {
        if (st < end) {
            int pivot = partition(arr , st , end);
            quickSort(arr , st , pivot-1);
            quickSort(arr , pivot+1 , end);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1 , 2, 4, 5, 6 ,20};
        QuickSort.quickSort(arr , 0 , arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
