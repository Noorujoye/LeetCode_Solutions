package Array;

public class checkArrayIsSortedAndRotated {
        public static boolean check(int[] nums) {
            int cnt = 0;
            for (int i=0; i<nums.length; i++) {
                if (nums[i] > nums[(i+1) % nums.length]) {
                    cnt++;
                }
            }
            return cnt <= 1;
        }
    public static void main(String[] args) {
        int[] arr = {10, 4, 5 ,1 ,2};
        boolean ans = checkArrayIsSortedAndRotated.check(arr);
        System.out.println(ans);
    }
}
