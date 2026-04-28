package DataStructurePatternWise.Heap.Top_K_Elements;

import java.util.PriorityQueue;

public class MinimumCostToConnectRopes {
    public static int minCostToConnectRopes(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : arr) minHeap.offer(i);
        int totalCost = 0;

        while (minHeap.size() > 1) {
            int first = minHeap.poll(); // first smallest
            int second  = minHeap.poll(); // second smallest
            int sum = first + second;
            totalCost += sum;
            minHeap.offer(sum); // add again to minHeap till last remain
        }
        return totalCost;
    }
    public static void main(String[] args) {
        int[] arr = {1 ,2 ,3, 5, 6, 3 ,1, 5 ,10};
        int minCost = MinimumCostToConnectRopes.minCostToConnectRopes(arr);
        System.out.println(minCost);

    }
}
