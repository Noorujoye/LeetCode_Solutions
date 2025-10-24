package TwoPointers;

import java.util.Arrays;

public class ThreeClosestSum16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                int diffToTarget = Math.abs(sum - target);
                if (diffToTarget < minDifference) {
                    closest = sum;
                    minDifference = diffToTarget;
                }
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,4,523,2,344,34344,};
        ThreeClosestSum16 t = new ThreeClosestSum16();
        int target = 500;
        int ans = t.threeSumClosest(arr , target);
        System.out.println(ans);

    }
}
