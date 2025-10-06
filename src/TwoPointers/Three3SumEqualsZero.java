package TwoPointers;

import java.util.*;

public class Three3SumEqualsZero {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length<3 || nums == null) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();


        for (int i=0; i<nums.length; i++) {

            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    left++;
                    right--;

                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] nums = {-1 , 0 , 1 , 2 , -1, -4};
        Three3SumEqualsZero obj = new Three3SumEqualsZero();
        List<List<Integer>> ans  = obj.threeSum(nums);
        System.out.println(ans);
        System.out.println("Total Triplets Found: " + ans.size());

    }
}
