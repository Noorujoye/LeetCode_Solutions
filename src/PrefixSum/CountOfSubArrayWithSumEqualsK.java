package PrefixSum;

import java.util.HashMap;

public class CountOfSubArrayWithSumEqualsK {
    public int subArrSum(int[] arr , int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int prefixSum = 0 , cnt = 0;
        for (int i=0; i<arr.length; i++) {
            prefixSum += arr[i];
            int remove = prefixSum - target;
            cnt += map.getOrDefault(remove , 0);

            // let's update our map with current prefixSum so that we can check further if we have remove again in the map or not
            map.put(prefixSum , map.getOrDefault(prefixSum , 0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,0,0,0};
        CountOfSubArrayWithSumEqualsK c = new CountOfSubArrayWithSumEqualsK();
        System.out.println(c.subArrSum(arr , 2));
        System.out.println(c.subArrSum(arr1 , 2));
        System.out.println(c.subArrSum(arr2 , 0));

    }
}

//Brute force
/*
public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count = 0;
        if (nums[0] == k) {
            return 1;
        }
        for (int i=0; i<n; i++) {
             int sum = 0;
            for (int j=i; j<n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
 */
