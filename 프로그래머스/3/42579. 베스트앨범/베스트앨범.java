import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수 계산
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);

            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, play});
        }

        // 2. 장르별 총 재생 횟수로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));

        // 3. 각 장르별로 노래 정렬 (재생 횟수 내림차순, 고유 번호 오름차순)
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

            // 최대 2곡 선택
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        // 결과 리스트를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
