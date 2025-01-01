import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int count = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= count) return count;
            count--;
        }        
        return 0;
    }
}