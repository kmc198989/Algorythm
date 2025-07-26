import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int [] con : edge) {
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }        
        
        return bfs(graph, n, 1);
    }
    public int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {
            int cur = que.poll();
            List<Integer> curlist = graph.get(cur);
            
            for (int next : curlist) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    que.offer(next);
                }
            }            
        }
        
        int max = 0;
        for (int d : distance) {
            max = Math.max(max, d);
        }
        int count = 0;
        for (int d : distance) {
            if (d == max) count++;
        }
        
        return count;
    }
}