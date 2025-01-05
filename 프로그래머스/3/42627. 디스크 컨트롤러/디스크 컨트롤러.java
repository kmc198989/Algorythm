import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> waitq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < jobs.length; i++) {
            waitq.add(new int[]{i, jobs[i][0], jobs[i][1]});
        }
        
        int result = 0;
        int time = 0;

        while (!waitq.isEmpty() || !pq.isEmpty()) {
            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                time += cur[2];
                result += time - cur[1];
            } else {
                time = waitq.peek()[1];
            }
            
            while (!waitq.isEmpty() && waitq.peek()[1] <= time) {
                pq.add(waitq.poll());
            }
        }
        
        return result / jobs.length;
    }
}