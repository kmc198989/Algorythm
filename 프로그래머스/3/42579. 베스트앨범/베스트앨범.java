import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        int len = genres.length;
        Map<String, Integer> playmap = new HashMap<>();
        Map<String, PriorityQueue<Song>> genremap = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            String gen = genres[i];
            int play = plays[i];
            playmap.put(gen, playmap.getOrDefault(gen, 0) + play);
            genremap.computeIfAbsent(gen, k -> new PriorityQueue<>((a, b) -> {
                if (a.play != b.play) return b.play - a.play;
                return a.idx - b.idx;
            })).add(new Song(play, i));
        }
        
        PriorityQueue<Genre> pq = new PriorityQueue<>((a, b) -> b.play - a.play);
        
        for (Map.Entry<String, Integer> entry : playmap.entrySet()) {
            pq.add(new Genre(entry.getValue(), entry.getKey()));
        }
        
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            String genre = pq.poll().name;
            PriorityQueue<Song> songs = genremap.get(genre);
            int length = Math.min(2, songs.size());
            for (int i = 0; i < length; i++) {
                result.add(songs.poll().idx);
            }
        }        
        answer = new int[result.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    class Song {
        int play;
        int idx;
        Song(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }
    
    class Genre {
        int play;
        String name;
        Genre(int play, String name) {
            this.play = play;
            this.name = name;
        }
    }
}