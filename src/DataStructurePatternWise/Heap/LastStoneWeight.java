package DataStructurePatternWise.Heap;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(( a , b) -> b-a);

        for (int i : stones) maxHeap.offer(i);

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.offer(first-second);
            }
        }
       return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
    public static void main(String[] args) {
        int[] stones = {2 , 3 , 19 , 29 , 64};
        System.out.println(lastStoneWeight(stones));
    }
}
