package DataStructurePatternWise.Heap.Top_K_Elements;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int kthLargest(int[] arr , int k) {
        PriorityQueue<Integer> kthLargest = new PriorityQueue<>();

        for (int i : arr) {
            kthLargest.offer(i);
            if (kthLargest.size() > k) {
                kthLargest.poll();
            }
        }
        return kthLargest.peek();
    }
    public static void main(String[] args) {
        int[] arr = {1 , 2, 3, 4, 5, 6 ,2, 1, 3, 4, 56 ,6, 6};
        int ans = KthLargestElementInArray.kthLargest(arr , 13);
        System.out.println(ans);
    }
}
