package DataStructurePatternWise.Array.TwoPointers;

public class MovesZeroToEnd {
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i=0; i<nums.length; i++) {
           if (nums[i] != 0) {
               if (idx != i) {
                   nums[idx] = nums[i];
                   nums[i] = 0;
               }
               idx++;
           }
       }
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1 , 2,4 , 5, 6, 0 , 33, 1, 0};
        moveZeroes(arr);
    }
}
