package PrefixSum;

import java.util.List;

public class LeftAndRightSumDifference {

    public int[] leftRightSumDiff(int[] nums) {

        int rightsum = 0;
        int leftSum = 0;
        int[] ans = new int[nums.length];
        for (int i : nums) {
            rightsum += i;
        }

        for (int i=0; i<nums.length; i++) {
            rightsum -= nums[i];
            ans[i] = Math.abs(leftSum - rightsum);
            leftSum += nums[i];
        }
        return ans;
    }
    static void main(String[] args){
        LeftAndRightSumDifference l = new LeftAndRightSumDifference();
        int[] nums = {1 , 10 , 20 , 15};
        nums  = l.leftRightSumDiff(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
