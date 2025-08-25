package Searching;

public class PeakElementInArray {
    /*public static int peakElement(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; i++){
            Boolean left = true;
            Boolean right = true;

            //check for left
            if (i>0 && arr[i] <= arr[i-1]) left = false;
            if (i<n-1 && arr[i] <= arr[i+1]) right = false;
            if (left && right) {
                return i;
            }
        }
        return -1;
    }*/

    public static int peakElement(int arr[]) {
        int n = arr.length;

        if (n == 1) {
            return 0;
        }
        if (arr[0] > arr[1])
            return 0;


        if (arr[n-1] > arr[n-2])
            return n-1;

        int low = 1, high = n-2;
        while (low<=high) {
            int mid = low+(high - low)/2;
            if (arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            if (arr[mid] < arr[mid+1])
                low = mid+1;
            else
                high = mid-1;

        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 7, 8, 3};
//        int peak = peakElement(arr);
        System.out.println("Peak element is: "+peakElement(arr));
    }
}
