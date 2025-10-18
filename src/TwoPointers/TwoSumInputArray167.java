package TwoPointers;
import java.util.Arrays;
public class TwoSumInputArray167 {
        public  int[] twoSum(int[] numbers, int target) {
            int low = 0;
            int high = numbers.length-1;
            while (low < high ) {
                int sum = numbers[low] + numbers[high];

                if (sum == target) {
                    return new int[] {low + 1 , high + 1};
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
            return new int[]{};
        }

    public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,7,8};
            int target = 10;
            TwoSumInputArray167 t = new TwoSumInputArray167();
            int[] result =  t.twoSum(arr , target);
            if (result.length > 0)
            System.out.println("Indices: " + result[0] + ", " + result[1]);
            else
                System.out.println("No pair found.");
    }
}
