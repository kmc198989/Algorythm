import java.util.*;

class Solution {    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int[][] map = new int[102][102];    // 좌표 확장(건너편 벽으로 건너뛰기 금지)
        int [] dx = {1, -1, 0, 0};
        int [] dy = {0, 0, 1, -1};
        
        for (int[] rec : rectangle) {       // 맵 채우기
            makeMap(map, rec);    
        }
        
        for (int[] rec : rectangle) {       // 테두리 제외 내부 지우기
            removeInside(map, rec);
        }
        
        // for (int i = 101; i >= 0; i--) {             // 맵 잘 찍혔는지 확인
        //     for (int j = 0; j < 102; j++) {
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        
        Queue<int[]> que = new LinkedList<>();
        int cx2 = characterX * 2; int cy2 = characterY * 2; int ix2 = itemX * 2; int iy2 = itemY * 2;
        que.add(new int[]{cx2, cy2, 0});
        map[cx2][cy2] = 0;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int curx = cur[0];
            int cury = cur[1];
            int dist = cur[2];
            System.out.println("dist = " + dist);
            if (curx == ix2 && cury == iy2) {
                return dist / 2;
            }
            for (int i = 0; i < 4; i++) {
                int nextx = curx + dx[i];
                int nexty = cury + dy[i];
                if (map[nextx][nexty] == 1) {
                    map[nextx][nexty] = 0;
                    que.add(new int[] {nextx, nexty, dist + 1});
                }
            }
        }
        
            
        return answer;
    }
    
    private void makeMap(int[][] map, int[] currec) {
        int ldx = currec[0] * 2;
        int ldy = currec[1] * 2;
        int rux = currec[2] * 2;
        int ruy = currec[3] * 2;
        
        for (int i = ldx; i <= rux; i++) {
            for (int j = ldy; j <= ruy; j++) {
                map[i][j] = 1;
            }
        }        
    }
    
    private void removeInside(int[][] map, int[] currec) {
        int ldx = currec[0] * 2;
        int ldy = currec[1] * 2;
        int rux = currec[2] * 2;
        int ruy = currec[3] * 2;
        
        for (int i = ldx + 1; i < rux; i++) {
            for (int j = ldy + 1; j < ruy; j++) {
                map[i][j] = 0;
            }
        }
    }
}