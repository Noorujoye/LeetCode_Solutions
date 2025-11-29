package HashMap;

import java.util.HashMap;

public class LargestSubArrayWithZeroSum {
    public int sumZero(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = 0;
        int sum = 0;
        for (int j=0; j<arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = Math.max(len , j-map.get(sum));
            } else {
                map.put(sum,j);
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        LargestSubArrayWithZeroSum l = new LargestSubArrayWithZeroSum();
        System.out.println(l.sumZero(arr));

    }
}
