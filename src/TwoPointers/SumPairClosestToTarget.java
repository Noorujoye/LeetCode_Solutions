package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SumPairClosestToTarget {
        public ArrayList<Integer> sumClosest(int[] arr, int target) {

            Arrays.sort(arr);
            int left = 0;
            int right = arr.length-1;

            int diff = Integer.MAX_VALUE;
            int first = -1;
            int second = -1;
            ArrayList<Integer> ans = new ArrayList<>();

            while (left < right) {
                int sum = arr[left] + arr[right];
                if ((diff > Math.abs(sum - target)) || ((diff == Math.abs(sum-target)) && arr[right]-arr[left] > second-first)) {
                    first = arr[left];
                    second = arr[right];
                    diff = Math.abs(sum-target);
                }
                if (sum <= target) left++;
                else right--;
            }
            if (first == -1 && second == -1) return ans;
            ans.add(first);
            ans.add(second);

            return ans;
        }

    public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,6,7,8,9,10,20,100};
            int target = 15;
            SumPairClosestToTarget s= new SumPairClosestToTarget();
            ArrayList<Integer> res = s.sumClosest(arr, target);
            System.out.println(res);
    }
}
