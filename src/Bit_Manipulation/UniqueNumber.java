package Bit_Manipulation;

public class UniqueNumber {

    public static int singleNumber(int[] nums) {

        int uNum = nums[0];
        for (int i=1; i<nums.length; i++) {
            uNum = uNum ^ nums[i];
        }
        return uNum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,4,};
        System.out.println(singleNumber(nums));
     }
}