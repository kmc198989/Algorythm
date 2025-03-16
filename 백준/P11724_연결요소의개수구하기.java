import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724_연결요소의개수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            graph[node].add(next);
            graph[next].add(node);
        }

        boolean[] visited = new boolean[N + 1];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            dfs (i, graph, visited);
            count++;
        }
        System.out.println(count);
    }

    public static void dfs (int node, List<Integer>[] graph, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next, graph, visited);
            }
        }
    }
}
