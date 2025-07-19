package heapandpriorityqueue;

import java.util.PriorityQueue;

public class KthLargest {

    private final PriorityQueue<Integer> priorityQueue;

    private final int size;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>(k);
        size = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < size) {
            priorityQueue.add(val);
        } else if (!priorityQueue.isEmpty() && priorityQueue.peek() < val) {
            priorityQueue.poll();
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}
