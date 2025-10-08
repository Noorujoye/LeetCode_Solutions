package TwoPointers;

import java.util.Arrays;

public class CountPairsWhoseSumIsLessThanTarget {
    public static int countPairs(int arr[], int target) {

        Arrays.sort(arr);
        int count = 0;
        int left = 0;
        int right = arr.length-1;

        for (int i=0; i<arr.length; i++) {
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum < target) {
                    count += right-left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,18,67};
        int target = 20;
        CountPairsWhoseSumIsLessThanTarget c = new CountPairsWhoseSumIsLessThanTarget();
        int ans = c.countPairs(arr , target);
        System.out.println(ans);
    }
}
