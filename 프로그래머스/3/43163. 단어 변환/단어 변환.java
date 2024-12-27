import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Word> que = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        Word start = new Word(begin, 0);
        que.add(start);
        
        while(!que.isEmpty()) {
            Word cur = que.poll();
            String curword = cur.word;
            int curcount = cur.count;
            if (curword.equals(target)) return curcount;
            
            for (int i = 0; i < words.length; i++) {
                String nextword = words[i];
                if (!visited[i] && canChange(curword, nextword)) {
                    Word next = new Word(nextword, curcount + 1);
                    que.add(next);
                    visited[i] = true;
                }
            }
        }        
        
        return answer;
    }
    
    private boolean canChange(String cur, String next) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i)) count++;
        }
        if (count == 1) return true;
        return false;
    }
    
    
    public class Word {
        String word;
        int count;
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}