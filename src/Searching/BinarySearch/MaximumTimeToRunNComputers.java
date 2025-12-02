package Searching.BinarySearch;

import java.util.Arrays;

public class MaximumTimeToRunNComputers {
    // Helper function to check if a given time 'T' is  achievable time or not
    private boolean canRun(long T, int[] batteries, int n) {
        long sum = 0;
        // For each battery, it can contribute a maximum of 'T' minutes
        // to the total running time across all computers.
        for (int a : batteries) {
            sum += Math.min((long)a, T);
        }
        // It is feasible if the total available minutes across all batteries
        // is enough to run 'n' computers for 'T' minutes each (n * T).
        return sum >= (long)n * T;
    }

    //main function
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);

        // Calculating  the total capacity of all batteries.
        long totalCapacity = 0;
        for (int i : batteries) {
            totalCapacity += i;
        }

        // The optimal time 'T' must be between 0 and the average available time
        long low = 0;
        long high = totalCapacity / n;

        long ans = 0; // Stores the best valid runtime found so far.

        // Binary search on the possible runtime 'T'.
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canRun(mid, batteries, n)) {
                // If 'mid' is feasible, it could be the answer.
                // We try a larger 'T' next by shifting the 'low' boundary up.
                ans = mid;
                low = mid + 1;
            } else {
                // If 'mid' is not achievable, we need a smaller 'T' means tine.
                // We shift the 'high' to down.
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        MaximumTimeToRunNComputers m = new MaximumTimeToRunNComputers();
        long answer = m.maxRunTime(3 , arr);
        System.out.println(answer);

    }
}
