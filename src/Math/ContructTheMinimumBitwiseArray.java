package Math;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; // Import Arrays for printing

public class ContructTheMinimumBitwiseArray {

    public static int[] bitwiseArr(List<Integer> list) {
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int num = list.get(i);
            if (num % 2 == 0) {
                ans[i] = -1; // Assign integer -1
            } else {
                ans[i] = check(num);
            }
        }
        return ans;
    }

    private static int check(int v) { // Made static to be called by static method
        for (int i = 1; i < v; i++) {
            if ((i | (i + 1)) == v) {
                return i;
            }
        }
        return -1; // Return -1 if no value is found
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        int[] ans = ContructTheMinimumBitwiseArray.bitwiseArr(nums);
        System.out.println(Arrays.toString(ans)); // Use Arrays.toString()
    }
}
