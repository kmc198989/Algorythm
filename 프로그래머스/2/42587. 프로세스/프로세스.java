import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> que = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < priorities.length; i++) {
            que.add(new int[] {priorities[i], i});
            pq.add(priorities[i]);
        }
        int count = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int prior = cur[0]; int idx = cur[1];
            if (prior == pq.peek()) {
                pq.poll();
                if (idx == location) return count;
                count++;
            } else {
                que.add(cur);
            }
        }
        
        return 0;
    }
}