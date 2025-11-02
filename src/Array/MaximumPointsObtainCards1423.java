package Array;

public class MaximumPointsObtainCards1423 {
    public int maximumPoints(int[] arr , int k) {

        int n = arr.length;
        int windowSize = n-k;
        int tSum = 0;
        for (int i : arr) tSum += i;

        if (k >= n) return tSum;

        //find min sum of subArray of size n-k
        int currentSum = 0;
        for (int i=0; i<windowSize; i++) {
            currentSum += arr[i];
        }
        int minWindowSum = currentSum;
        for (int i=windowSize; i<n; i++) {
            currentSum += arr[i] - arr[i - windowSize];
            minWindowSum = Math.min(minWindowSum , currentSum);
        }

        return tSum-minWindowSum;
    }
    public static void main(String[] args) {
        int[] arr = {2,4,1,1,5,7,8};
        int k = 5;
        int b = 2;
        MaximumPointsObtainCards1423 m = new MaximumPointsObtainCards1423();
        System.out.println(m.maximumPoints(arr , k));
        System.out.println(m.maximumPoints(arr , b));
    }
}