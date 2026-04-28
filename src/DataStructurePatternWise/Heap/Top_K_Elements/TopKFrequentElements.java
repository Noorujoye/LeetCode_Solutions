package DataStructurePatternWise.Heap.Top_K_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] kFrequentElements(int[] arr , int k) {
        // stores the frequency
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i , map.getOrDefault(i , 0) + 1);
        }

        // for fast operation , create a minHeap to store less count value to front of the queue to easy deletion,
        // by default it is in ascending order,
        PriorityQueue<Map.Entry<Integer , Integer>> minHeap = new PriorityQueue<>((a , b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer , Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int i=0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1 , 2, 4, 5,6, 7,7,1, 3 ,1 ,3, 4};
        int k = 3;
        arr = TopKFrequentElements.kFrequentElements(arr , k);
        for (int i : arr) {
            System.out.println(i + " ");
        }

    }
}
