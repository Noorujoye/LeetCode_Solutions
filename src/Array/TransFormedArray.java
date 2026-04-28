package Array;

public class TransFormedArray {
        public static int[] constructTransformedArray(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];

            // for (int i=0; i<n; i++) {
            //     if (nums[i] > 0) {
            //         int idx = (i + nums[i]) % n;
            //         result[i] = nums[idx];
            //     } else if (nums[i] < 0) {
            //         int idx = ((i + nums[i]) + n) % n;
            //         result[i] = nums[idx];
            //     } else {
            //         result[i] = nums[i];
            //     }
            // }


            for (int i=0; i<n; i++) {
                int idx = ((i+nums[i]) % n + n) % n; // universal formula , no need to check for negative with extra formula
                result[i] = nums[idx];
            }
            return result;
        }

    public static void main(String[] args) {
        int[] arr = {3 , -2 , 1 , 1};
        arr = TransFormedArray.constructTransformedArray(arr);
        for (int i : arr) {
            System.out.println(i + ",");
        }
    }
}
