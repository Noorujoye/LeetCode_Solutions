package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarr(nums ,  k) - subarr(nums ,k-1);
    }
    private int subarr(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int start=0 , count=0;

        for (int end=0; end<nums.length; end++) {
            int value = nums[end];
            map.put(value , map.getOrDefault(value , 0)+1);

            while (map.size() > k) {
                map.put(nums[start] , map.get(nums[start])-1);
                if (map.get(nums[start]) == 0) {
                    map.remove(nums[start]);
                }
                start++;
            }
            count += end-start+1;
        }
        return count;t a
    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,7,9,4,5,7,8,1,5,7};
        SubArrayWithKDifferentIntegers s = new SubArrayWithKDifferentIntegers();
        System.out.println(s.subarraysWithKDistinct(arr , 3));
    }
}

//brute force
/*
public int subarraysWithKDistinct(int[] nums, int k) {

        int count = 0;

        for (int i=0; i<nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j=i; j<nums.length; j++) {
                int val = nums[j];
                set.add(val);
                if (set.size() == k) {
                    count++;
                }
                if (set.size() > k) break;
            }
        }
        return count;
    }
 */
