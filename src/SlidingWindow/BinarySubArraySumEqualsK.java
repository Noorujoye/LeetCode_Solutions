package SlidingWindow;

public class BinarySubArraySumEqualsK {
    public int binarySubArr(int[] arr , int target) {
        return countSubArr(arr , target) - countSubArr(arr , target-1);
    }
    private int countSubArr(int[] arr , int target) {

        if (target < 0) return 0;
        int count=0;
        int start=0;
        int sum = 0;

        for (int end=0; end<arr.length; end++) {
            sum += arr[end];

            while (sum > target) {
                sum -= arr[start];
                start++;
            }
            count += end-start+1;

        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1};
        int[] arr1 = {1,0,0};
        int[] arr2 = {1,1,1,0,0,0};
        BinarySubArraySumEqualsK b = new BinarySubArraySumEqualsK();
        System.out.println(b.binarySubArr(arr , 1));
        System.out.println(b.binarySubArr(arr1 , 2));
        System.out.println(b.binarySubArr(arr2 , 3));

    }
}
