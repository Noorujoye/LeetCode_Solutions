package SlidingWindow;

import java.util.HashMap;

public class SubArrayWithKDifferentIntegers {
    /**
     * Main function: Reframes "exactly K" into two "at most" problems.
     * Time Complexity: O(N) because each element is visited twice.
     * Space Complexity: O(K) for the frequency map.
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Formula: Exactly K = (Subarrays with <= K) - (Subarrays with <= K-1)
        return subarr(nums, k) - subarr(nums, k - 1);
    }
    /**
     * Helper: Counts all contiguous subarrays having AT MOST 'k' distinct integers.
     */
    private int subarr(int[] nums, int k) {
        // Frequency map to track distinct elements and their counts in the current window
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, count = 0;

        // 'end' pointer expands the window to the right
        for (int end = 0; end < nums.length; end++) {
            int value = nums[end];
            map.put(value, map.getOrDefault(value, 0) + 1);

            // If distinct elements exceed k, shrink window from the left
            while (map.size() > k) {
                int leftVal = nums[start];
                map.put(leftVal, map.get(leftVal) - 1);

                // If count becomes 0, that integer is no longer in the window
                if (map.get(leftVal) == 0) {
                    map.remove(leftVal);
                }
                start++; // Move left pointer to shrink
            }
            /*
             * CRITICAL LOGIC:
             * (end - start + 1) represents the number of subarrays ending at 'end'
             * that have AT MOST k distinct elements.
             * Example: If window is [1, 2, 3] and k=3, subarrays ending at '3'
             * are [3], [2, 3], and [1, 2, 3]. Total = 3 - 0 + 1 = 3.
             */
            count += (end - start + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 7, 9, 4, 5, 7, 8, 1, 5, 7};
        SubArrayWithKDifferentIntegers s = new SubArrayWithKDifferentIntegers();
        // [LeetCode 992] - Subarrays with K Different Integers
        System.out.println("Total subarrays with exactly 3 distinct: " + s.subarraysWithKDistinct(arr, 3));
    }
}
