package SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class LongestSubArrWithAboDiff {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        ArrayList<Integer> res = new ArrayList<>();


        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        int n = arr.length;
        int start = 0, end = 0;
        int resStart = 0, resEnd = 0;

        while (end < n) {

            //Maintain increasing order in minQueue
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();

            //Maintain decreasing order in maxQueue
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();

            // Add current index to both queues
            minQueue.addLast(end);
            maxQueue.addLast(end);

            // Shrink window if difference > x
            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                if (start == minQueue.peekFirst()) minQueue.pollFirst();
                if (start == maxQueue.peekFirst()) maxQueue.pollFirst();
                start++;
            }

            // Update longest valid subarray range
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }

            end++;
        }

        // Collect final result
        for (int i = resStart; i <= resEnd; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        LongestSubArrWithAboDiff longestSubArrWithAboDiff = new LongestSubArrWithAboDiff();
        int[] arr = {8, 4, 5, 6, 7};
        int x = 3;
        ArrayList<Integer> res = longestSubArrWithAboDiff.longestSubarray(arr, x);
        System.out.println(res);
    }

}

