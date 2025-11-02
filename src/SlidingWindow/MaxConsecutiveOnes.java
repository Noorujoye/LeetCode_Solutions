package SlidingWindow;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int no_zeros = 0;
        int maxOnes = 0;

        for (int end=0; end<nums.length; end++) {
            if (nums[end] == 0) no_zeros++;
            //  Shrink the  window if zeros > k
            while (no_zeros > k) {
                if (nums[start] == 0) no_zeros--;
                start++;
            }

            maxOnes = Math.max(maxOnes , end - start + 1);
        }
        return maxOnes;
    }

      public static void main(String[] args){
        int[] binaryArray = {0,0,0};
        int k = 1;
        MaxConsecutiveOnes m = new MaxConsecutiveOnes();
        System.out.println(m.longestOnes(binaryArray , k));

      }
}
