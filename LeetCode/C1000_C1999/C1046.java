package C1000_C1999;

import java.util.PriorityQueue;
import java.util.Queue;

public class C1046 {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            if (a != b) queue.offer(a - b);
        }
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
