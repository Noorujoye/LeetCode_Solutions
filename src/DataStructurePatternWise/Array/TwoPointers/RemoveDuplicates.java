package DataStructurePatternWise.Array.TwoPointers;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int k = 1; // first element is always unique
        for (int i=1; i<nums.length; i++) {
            // duplicated are adjacent , so just check last one with current and if yes simply put it on kth index and move kth for a new index
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++; // new index
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3 , 4 , 5};
        int k  = RemoveDuplicates.removeDuplicates(arr);
        for (int i=0; i<k; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
