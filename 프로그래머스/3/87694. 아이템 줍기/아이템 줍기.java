import java.util.*;

class Solution {
    static int[][] map;
    static int[] dx;
    static int[] dy;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        map = new int[102][102];
        int x2 = characterX * 2;
        int y2 = characterY * 2;
        int itemx2 = itemX * 2;
        int itemy2 = itemY * 2;
        dx = new int[]{1, -1, 0, 0};
        dy = new int[]{0, 0, 1, -1};
        drawMap(rectangle);
        removeIn(rectangle);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x2, y2, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            int dist = cur[2];
            if (curx == itemx2 && cury == itemy2) return dist / 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.add(new int[]{nx, ny, dist+1});
                }
            }
            
        }
        
        return answer;
    }
    
    private void drawMap(int[][] rectangle) {
        for (int[] rectan : rectangle) {
            int ldx = rectan[0] * 2;
            int ldy = rectan[1] * 2;
            int rux = rectan[2] * 2;
            int ruy = rectan[3] * 2;
            for (int i = ldx; i <= rux; i++) {
                for (int j = ldy; j <= ruy; j++) {
                    map[i][j] = 1;
                }
            }
        }
    }
    
    private void removeIn(int[][] rectangle) {
        for (int[] rectan : rectangle) {
            int ldx = rectan[0] * 2;
            int ldy = rectan[1] * 2;
            int rux = rectan[2] * 2;
            int ruy = rectan[3] * 2;
            for (int i = ldx + 1; i < rux; i++) {
                for (int j = ldy + 1; j < ruy; j++) {
                    map[i][j] = 0;
                }
            }
        }
    }
    
}