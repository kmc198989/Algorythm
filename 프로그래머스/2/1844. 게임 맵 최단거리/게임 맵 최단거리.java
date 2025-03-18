import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int m = maps[0].length;
        int n = maps.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curD = cur[2];
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                if (nextX == m - 1 && nextY == n - 1) return curD + 1;
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maps[nextY][nextX] == 1) {
                    maps[nextY][nextX] = 0;
                    q.add(new int[] {nextX, nextY, curD + 1});
                }
            }
        }
        
        return -1;
    }
}