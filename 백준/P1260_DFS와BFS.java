import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFS와BFS {
    static List<Integer>[] graph;
    static StringBuilder sb;
    static boolean[] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        dfs(start);
        sb.append("\n");

        visited = new boolean[N + 1];
        bfs(start);

        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
