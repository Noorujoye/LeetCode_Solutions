package Bit_Manipulation;

public class UniqueNumber2 {

    public static int[] singleNumber(int[] nums) {

        int xorVal = 0;
        for (int i:nums) {
            xorVal^=i;
        }

        xorVal &= -xorVal;
        int[] res = new int[2];

        for (int num : nums) {
            if ((num & xorVal) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        if (res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 1, 4 };
        nums = singleNumber(nums);
        System.out.println(nums[0] + " " + nums[1]);

    }
}