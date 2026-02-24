package DataStructurePatternWise.Heap.MergeKSorted;

import javax.swing.*;
import java.util.*;

public class FindKPairsWithSmallestSums {
    static class Pair {
        int i;
        int j;
        long sum; // avoid overflow (long)

         Pair(int i , int j , int[] nums1 , int[] nums2) {
            this.i=i;
            this.j=j;
            this.sum = (long) nums1[i] + nums2[j];
        }
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1 , int[] nums2 , int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || k == 0 || nums2.length == 0) return result;

        /*
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(

                (a , b) -> Long.compare(
                        (long)nums1[a[0]] + nums2[a[1]],
                        (long)nums1[b[0]] + nums2[b[1]]
                )
        );
        */

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingLong(p -> p.sum));

        // first push each row smallest
        for (int i=0; i < nums1.length && i < k; i++) {
            minHeap.offer(new Pair(i , 0 , nums1, nums2));
        }

        while (k > 0 && !minHeap.isEmpty()) {
           Pair curr = minHeap.poll();
           result.add(Arrays.asList(nums1[curr.i], nums2[curr.j]));

           // push next element in same row
           if (curr.j + 1 < nums2.length) {
               minHeap.offer(new Pair(curr.i , curr.j+1 , nums1, nums2));
           }
           k--;
        }
        return result;
    }
    public static void main(String[] args) {

        FindKPairsWithSmallestSums sol = new FindKPairsWithSmallestSums();
        //Test case 1
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println("Test case 1: ");
        System.out.println(sol.kSmallestPairs(nums1 , nums2 , k));
    }
}
