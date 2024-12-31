import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> map = new HashMap<>();
        int[] answer = {};
        int len = genres.length;
        for (int i = 0; i < len; i++) {
            map.putIfAbsent(genres[i], new Genre());
        }
        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int play = plays[i];
            Genre genclass = map.get(genre);
            genclass.name = genre;
            genclass.total += play;
            genclass.index.add(new int[]{i, play});
        }
        PriorityQueue<Genre> pq = new PriorityQueue<>((a,b) -> b.total - a.total);
        for (Map.Entry<String, Genre> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            Genre genclass = pq.poll();
            for (int i = 0; i < 2; i++) {
                if (!genclass.index.isEmpty()) {
                    result.add(genclass.index.poll()[0]);
                }
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public class Genre {
        String name;
        int total;
        PriorityQueue<int[]> index = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });
    }
}