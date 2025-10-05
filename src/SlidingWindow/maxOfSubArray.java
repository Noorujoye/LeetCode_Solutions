package SlidingWindow;

import java.util.*;  // For ArrayList and Deque classes

class Solution {

    // Function to find maximum element in every subarray of size k
    public ArrayList<Integer> maxOfSubArray(int[] arr, int k) {

        int n = arr.length; // length of the array

        // Result list to store the maximum of each window
        ArrayList<Integer> res = new ArrayList<>();

        // Deque to store indexes of useful elements (in decreasing order of their values)
        Deque<Integer> dq = new ArrayDeque<>();


        //  Step 1: Process the first window (first k elements)
        for (int i = 0; i < k; ++i) {

            // Remove all elements smaller than the current one (since they are useless)
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast(); // remove from rear
            }

            // Add current index at the rear of deque
            dq.addLast(i);
        }


        //  Step 2: Process the rest of the elements (from index k to n-1)
        for (int i = k; i < n; ++i) {

            // The element at the front of deque is the largest of the previous window
            res.add(arr[dq.peekFirst()]);

            // Remove indexes which are out of this window (outdated elements)
            // Example: if current index is 4 and k=3, then window = [2,3,4],
            // so anything <= 1 (4-3) is out of window.
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst(); // remove from front
            }

            // Remove all smaller elements than the current element
            // because they can't be the maximum for any upcoming window
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast(); // remove from rear
            }

            // Add current index at the rear
            dq.addLast(i);
        }


        //  Step 3: Add maximum element of the last window
        res.add(arr[dq.peekFirst()]);

        // Return the result list
        return res;
    }


    //  Main method for testing and understanding
    public static void main(String[] args) {

        Solution sol = new Solution();

        // Example array
        int[] arr = {1, 3, 2, 1, 7, 3};

        // Window size
        int k = 3;

        // Function call to get result
        ArrayList<Integer> result = sol.maxOfSubArray(arr, k);

        // Print the results
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Window size: " + k);
        System.out.println("Maximum of each window: " + result);
    }
}

