package Searching;

public class SearchInRotatedSortedArray {
    public static int Searching(int[] nums, int target) {

        int low = 0 , high = nums.length-1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] ==  target)
                return mid;

            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target <= nums[mid])

                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else {
                if (target >= nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int nums[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int result = Searching(nums , 3);
        System.out.println(result);
    }
}
