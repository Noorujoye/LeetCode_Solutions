package Array;

public class EquilibriumPoint {
    public static int equilibriumPoint(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        right[nums.length - 1] = 0;
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }
        for (int i=0; i<nums.length; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    /*
     static int equilibriumPoint(int[] arr) {
        int prefSum = 0, total = 0;

        // Calculate the array sum
        for (int ele : arr) {
            total += ele;
        }

        // Iterate pivot over all the elements of the array
        for (int pivot = 0; pivot < arr.length; pivot++) {
            int suffSum = total - prefSum - arr[pivot];
            if (prefSum == suffSum) {
                return pivot;
            }
            prefSum += arr[pivot];
        }

        // There is no equilibrium point
        return -1;
    }
    */

    public static void main(String[] args) {
        int[] nums = {5,1, 2, 3,1,2 ,5};
        int res = equilibriumPoint(nums);

        if (res != -1) {
            System.out.println(res);
        } else {
            System.out.println("Not found");
        }
    }
}
