package DataStructurePatternWise.Array.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumEqualsToZero {
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        for (int i=0; i<arr.length-2; i++) {
            int left = i+1;
            int right = arr.length-1;
            if (i > 0 && arr[i] == arr[i-1]) continue;
            if (arr[i] > 0) break; // edge case
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();

                    list.add(arr[i]);
                    list.add(arr[left]);
                    list.add(arr[right]);
                    result.add(list);
                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {2 , 1 , -1, 0 , 4 , 0 , 1 , 7};
        List<List<Integer>> result = ThreeSumEqualsToZero.threeSum(arr);
        for (List<Integer> i : result) {
            System.out.print(i + " ");
        }
    }
}
