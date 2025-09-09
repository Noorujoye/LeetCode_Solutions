package Array;

import java.util.HashMap;

public class ContigousArray {
    public static int subArray(int[] arr) {
        HashMap<Integer,Integer> subArray = new HashMap<>();

        int res = 0;
        int presum = 0;

        for (int i=0; i<arr.length; i++) {

            presum += (presum == 0) ? -1 : 1;

            if (presum == 0) {
                res = i+1;
            }
            if (subArray.containsKey(presum)) {
                res = Math.max(res , i-subArray.get(presum));
            } else {
                subArray.put(presum,i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,0,1,0,0,0};
        int ans = subArray(arr);
        System.out.println(ans);
    }
}
