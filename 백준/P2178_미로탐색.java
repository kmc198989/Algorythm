import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        //         남  북  동  서
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Node> q = new LinkedList<>();
        Node start = new Node(0, 0, 1); // 시작 지점, 거리 1부터 시작
        q.add(start);
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            if (x == N - 1 && y == M - 1) {
                System.out.println(dist);
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new Node(nx, ny, dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(0);
    }

    static class Node {
        int x;
        int y;
        int dist;

        Node (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
