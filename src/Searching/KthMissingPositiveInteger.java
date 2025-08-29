package Searching;

public class KthMissingPositiveInteger {
    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length-1, res = arr.length+k;

        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid] > mid+k) {
                res = mid+k;
                high=mid-1;
            } else {
                low = mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int k=2;
        int result = findKthPositive(arr,k);
        System.out.println(result);
    }
}
