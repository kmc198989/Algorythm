import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        List<Set<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new HashSet<>());
        }
        
        
        for (int[] e : edge) {
            edges.get(e[0]).add(e[1]);
            edges.get(e[1]).add(e[0]);
        }
        
        answer = bfs(edges, visited, 1);
        
        return answer;
    }
    
    private int bfs(List<Set<Integer>> edges, boolean[] visited, int start) {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 1});
        visited[1] = true;
        int[] len = new int[edges.size() + 1];
        len[1]++;
        int max = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int node : edges.get(cur[0])) {
                if (!visited[node]) {
                    visited[node] = true;
                    int far = cur[1] + 1;
                    q.add(new int[] {node, far});
                    len[far]++;
                    max = Math.max(max, far);
                }
            }
        }
        
        return len[max];
        
    }
}