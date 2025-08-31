package Bit_Manipulation;

public class MissingNumber {
    public static int findNum(int[] nums) {
        int n= nums.length;
        int xor=n;
        for (int i=0; i<n; i++) {
            xor^=i;
            xor^=nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5};
        System.out.println(findNum(nums));
    }
}
