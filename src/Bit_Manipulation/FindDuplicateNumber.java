package Bit_Manipulation;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // create two pointers
        int slow = nums[0] ,  fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        //reinitialize fast
        fast = nums[0];
        while(slow != fast ) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,4,5,3,2};
        FindDuplicateNumber f = new FindDuplicateNumber();
        System.out.println(f.findDuplicate(nums));
    }
}