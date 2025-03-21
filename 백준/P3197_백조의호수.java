import java.util.*;
import java.io.*;

public class P3197_백조의호수 {
    public static void main(String[] args) throws Exception {
        SwanLake lake = new SwanLake();
        lake.initLake();
        System.out.println(lake.lakeProcess());
    }
}

class SwanLake {
    int R, C;
    char[][] lake;
    Point swan1; Point swan2;
    Queue<Point> swanQ, swanNext, waterQ, waterNext;
    boolean[][] swanVisited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    void initLake() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lake = new char[R][C];
        swan1 = null; swan2 = null;
        swanQ = new LinkedList<>(); swanNext = new LinkedList<>();
        waterQ = new LinkedList<>(); waterNext = new LinkedList<>();
        swanVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            drawMap(i, line);
        }
        swanQ.add(swan1); swanVisited[swan1.x][swan1.y] = true;
    }

    void drawMap(int i, String line) {
        for (int j = 0; j < C; j++) {
            lake[i][j] = line.charAt(j);
            if (lake[i][j] == 'L') {
                if (swan1 == null) swan1 = new Point(i, j);
                else swan2 = new Point(i, j);
                waterQ.add(new Point(i, j));
            }
            else if (lake[i][j] == '.') waterQ.add(new Point(i, j));
        }
    }

    int lakeProcess() {
        int days = 0;
        while (!meetSwan()) {
            waterMelt();
            swanQ = swanNext; swanNext = new LinkedList<>();
            waterQ = waterNext; waterNext = new LinkedList<>();
            days++;
        }
        return days;
    }

    boolean meetSwan() {
        while (!swanQ.isEmpty()) {
            Point cur = swanQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx == swan2.x && ny == swan2.y) return true;
                if (inValid(nx, ny) && !swanVisited[nx][ny]) {
                    swanVisited[nx][ny] = true;
                    if (lake[nx][ny] == '.') swanQ.add(new Point(nx, ny));
                    else if (lake[nx][ny] == 'X') swanNext.add(new Point(nx, ny));
                }
            }
        }
        return false;
    }

    void waterMelt() {
        while (!waterQ.isEmpty()) {
            Point cur = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (inValid(nx, ny) && lake[nx][ny] == 'X') {
                    lake[nx][ny] = '.';
                    waterNext.add(new Point(nx, ny));
                }
            }
        }
    }


    boolean inValid(int x, int y) {
        if (x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }
}

class Point {
    int x;
    int y;
    Point (int x, int y) {
        this.x = x; this.y = y;
    }
}

