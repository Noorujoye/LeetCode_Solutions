package SlidingWindow;

public class NiceSubArray {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[] nums ,int k) {

        int start = 0, oddCount = 0, count = 0;
        for (int end=0; end<nums.length; end++) {
            int value = nums[end];
            if (value % 2 == 1) {
                oddCount++;
            }
            if (oddCount > k) {
                if (nums[start] % 2 == 1) oddCount--;
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1};
        NiceSubArray n = new NiceSubArray();
        System.out.println(n.numberOfSubarrays(arr , 3));
    }
}
