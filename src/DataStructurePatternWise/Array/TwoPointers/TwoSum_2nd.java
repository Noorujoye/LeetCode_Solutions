package DataStructurePatternWise.Array.TwoPointers;

public class TwoSum_2nd {
    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int sum = 0;

        while (low < high) {
            sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1 , high + 1};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] arr = { 1 , 2 , 3 , 4 , 5};
        arr = TwoSum_2nd.twoSum(arr, 3);
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println(arr.length);
    }
}
