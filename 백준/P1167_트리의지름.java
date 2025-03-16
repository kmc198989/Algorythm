import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1167_트리의지름 {
    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDistance = 0;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new Node(to, weight));
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        maxDistance = 0;
        dfs(maxNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int distance) {
        visited[node] = true;
        if (distance > maxDistance) {
            maxDistance = distance;
            maxNode = node;
        }

        for (Node neighbor : tree[node]) {
            if (!visited[neighbor.to]) {
                dfs(neighbor.to, distance + neighbor.weight);
            }
        }
    }
}
