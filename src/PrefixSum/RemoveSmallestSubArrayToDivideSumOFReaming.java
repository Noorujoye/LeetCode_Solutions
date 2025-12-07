package PrefixSum;

import java.util.HashMap;

public class RemoveSmallestSubArrayToDivideSumOFReaming {
    public int minSubarray(int[] nums, int p) {

        long tSum = 0;
        for (int n : nums) {
            tSum += n;
        }
        int remainder = (int)(tSum % p);
        if (remainder == 0) {
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0, -1);

        long prefix = 0;
        int minLen = nums.length; // max len possible

        for (int j=0; j<nums.length; j++) {
            prefix = (prefix + nums[j]); //subarray ka mod

            int curMod = (int)(prefix % p);

            int needed = (curMod - remainder + p) % p;

            if (map.containsKey(needed)) {
                int i = map.get(needed);
                minLen = Math.min(minLen, j-i);
            }
            map.put(curMod , j);
        }

        return minLen == nums.length ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,77,8};
        int p = 4;
        RemoveSmallestSubArrayToDivideSumOFReaming r = new RemoveSmallestSubArrayToDivideSumOFReaming();
        System.out.println(r.minSubarray(arr , p));
    }
}