package SlidingWindow;

import java.util.List;

public class SumOfMinimumSubArrayOfGiven3364 {
        public int minimumSumSubarray(List<Integer> nums, int l, int r) {
            int n = nums.size();
            int ans = Integer.MAX_VALUE;
            for (int start = 0; start <= n-l; start++) {
                int sum = 0;
                for (int size = 1; size <= r; size++) {
                    if (start + size - 1 >= n)
                        break;
                    sum += nums.get(start + size-1);
                    if (size >= l && sum > 0) {
                        ans = Math.min(ans , sum);
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    public static void main(String[] args) {
        List nums = new int{1, 3, 4, 5, 6, 6};
        SumOfMinimumSubArrayOfGiven3364 s = new SumOfMinimumSubArrayOfGiven3364();
        int ans = s.minimumSumSubarray( nums, 2 , 3);
    }
}
