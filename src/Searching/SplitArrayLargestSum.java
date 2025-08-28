package Searching;
import java.util.*;
public class SplitArrayLargestSum {
    public static boolean splitArrLarSum(int[] nums, int k, int mid) {
        int count = 1;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            if (sum+nums[i] > mid){
                count++;
                sum  = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return (count<=k);
    }
    public static int splitArray(int[] nums, int k) {

        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        int res = high;

        if (k>nums.length) return -1;
        while (low <= high) {
            int mid = (high+low)/2;
            if(splitArrLarSum(nums,k,mid)){
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {7,2,5,10,8};
        int k = 2;
        int result = splitArray(nums , k);
        System.out.println(result);
    }
}
