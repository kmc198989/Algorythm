import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scov : scoville) pq.add(scov);
        
        while (pq.size() >= 2) {
            if (pq.peek() >= K) return count;
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);
            count++;
        }
        
        if (pq.peek() >= K) return count;
        return -1;
    }
}