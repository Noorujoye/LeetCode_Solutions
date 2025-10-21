package Searching.BinarySearch;

import java.util.Arrays;

public class FirstAndLastIndexOfSameElementInSortedArray34 {
    public  int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};


        int left = findLeftBound(nums , target);
        int right = findRightBound(nums , target);

        return new int[]{left , right};
    }
    private  int findLeftBound(int[] nums , int target) {

        int low = 0;
        int high = nums.length-1;
        int idx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                idx = mid; // store the found index
                high = mid-1; // will search from low to new high which is left part
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }
    private int findRightBound(int[] nums , int target) {

        int low = 0;
        int high = nums.length-1;
        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                idx = mid;
                low = mid+1; // will search from new low to high  which is right part
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,9};
        int target = 2;
        FirstAndLastIndexOfSameElementInSortedArray34 f = new FirstAndLastIndexOfSameElementInSortedArray34();
        int[] indexes = f.searchRange(arr , target);
        System.out.println("first index is : " + indexes[0] + "\n" + "Last Index is : " + indexes[1]);
    }
}// the above functions will work on sorted arrays but we have not pass the sorted array so we will sort it inside the function first
// but not a good practice