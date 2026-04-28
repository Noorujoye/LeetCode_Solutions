package DataStructurePatternWise.Heap.Top_K_Elements;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> maxHeap; // left side maximum , storing it as reverse order
    PriorityQueue<Integer> minHeap; // right side smallest

    //initialize
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>( (a , b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    public double median() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return (double) maxHeap.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        double median = obj.median();
        System.out.println(median);
    }
}
