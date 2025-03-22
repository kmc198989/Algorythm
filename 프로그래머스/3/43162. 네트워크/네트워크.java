import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;
            dfs(i, n, computers);
        }
        
        return answer;
    }
    
    private void dfs(int cur, int n, int[][] computers) {
        if (!visited[cur]) {
            visited[cur] = true;
        } else {
            return;
        }
        for (int i = 0; i < n; i++) {
            int com = computers[cur][i];
            if (com == 1 && !visited[i]) {
                dfs (i, n, computers);
            }
        }        
    }
}