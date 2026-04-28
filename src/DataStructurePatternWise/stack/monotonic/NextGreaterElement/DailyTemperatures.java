package DataStructurePatternWise.stack.monotonic.NextGreaterElement;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: LeetCode 739 - Daily Temperatures
 * Goal: For each day, find how many days to wait for a warmer temperature.
 * Logic: Monotonic Stack (Decreasing from bottom to top).
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // Use Deque as a Stack (stores indices of future warmer days)
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse backwards: We need to know 'future' temperatures to solve for 'today'
        for (int i = n - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];

            // 1. POP: Remove days that are colder than or equal to today.
            // They can't be the "next warmer day" for any day before today.
            while (!stack.isEmpty() && currentTemp >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // 2. CALCULATE: If stack isn't empty, the top is the nearest warmer day.
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            }

            // 3. PUSH: Add today's index to the stack for earlier days to consider.
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures solver = new DailyTemperatures();
        int[] result = solver.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
