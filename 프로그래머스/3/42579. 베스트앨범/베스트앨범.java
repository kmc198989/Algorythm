import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre = new HashMap<>();
        Map<String, PriorityQueue<Song>> songs = new HashMap<>();
        
        int len = genres.length;
        
        for (int i = 0; i < len; i++) {
            String gen = genres[i];
            int pl = plays[i];
            genre.put(gen, genre.getOrDefault(gen, 0) + pl);
            songs.computeIfAbsent(gen, s -> new PriorityQueue<>((a, b) -> {
                if (a.play != b.play) {
                    return Integer.compare(b.play, a.play);
                } else {
                    return Integer.compare(a.index, b.index);
                }
            })).add(new Song(i, pl));            
        }

        List<String> g = new ArrayList<>(genre.keySet());
        g.sort((a, b) -> Integer.compare(genre.get(b), genre.get(a)));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < g.size(); i++) {
            String curgen = g.get(i);
            PriorityQueue<Song> pq = songs.get(curgen);
            for (int j = 0; j < 2 && !pq.isEmpty(); j++) {
                result.add(pq.poll().index);
            }
        }
        
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public class Song {
        int index;
        int play;
        
        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}