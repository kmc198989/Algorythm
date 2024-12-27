import java.util.*;

class Solution {
    public static List<List<String>> results = new ArrayList<>();
    public static Map<String, List<Ticket>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {
        int len = tickets.length;

        // 항공권 정보 map에 저장
        for (int i = 0; i < len; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(new Ticket(start, end, i));
        }

        boolean[] visited = new boolean[len];
        List<String> path = new ArrayList<>();
        path.add("ICN");

        // DFS 탐색
        dfs("ICN", visited, path, len, 0);

        // 결과 정렬 후 첫 번째 경로 반환
        results.sort((a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return results.get(0).toArray(new String[0]);
    }

    private void dfs(String start, boolean[] visited, List<String> path, int len, int count) {
        if (len == count) {
            results.add(new ArrayList<>(path)); // 현재 경로 저장
            return;
        }

        // 현재 출발지에서 가능한 항공권 탐색
        if (map.containsKey(start)) {
            for (Ticket ticket : map.get(start)) {
                String end = ticket.end;
                int idx = ticket.idx;
                if (!visited[idx]) {
                    visited[idx] = true;
                    path.add(end);

                    dfs(end, visited, path, len, count + 1);

                    // 백트래킹
                    visited[idx] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public class Ticket {
        String start;
        String end;
        int idx;

        Ticket(String start, String end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }
    }
}
