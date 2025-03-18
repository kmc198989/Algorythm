class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int length = words.length;
        boolean[] visited = new boolean[length];
        answer = dfs (begin, target, words, visited, 0, 0, length);
        return answer;
    }
    
    private int dfs (String cur, String target, String[] words, boolean[] visited, int idx, int count, int length) {
        if (cur.equals(target)) return count;
        System.out.println("dfs");
        int result = 0;
        
        for (int i = 0; i < length; i++) {
            if (visited[i]) continue;
            String word = words[i];
            if (canChange(word, cur)) {
                visited[i] = true;
                result = dfs (word, target, words, visited, i, count + 1, length);
                visited[i] = false;
            }
        }
        
        return result;
    }
    
    private boolean canChange (String word, String cur) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == cur.charAt(i)) count++;
        }
        if (count == word.length() - 1) return true;
        return false;
    }
}