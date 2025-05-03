import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int a = arr1[i] | arr2[i];
            answer[i] = toChange(a, n);
        }
        
        return answer;
    }
    
    private String toChange(int a, int n) {
        StringBuilder sb = new StringBuilder();
        while (a > 0) {
            int p = a % 2;
            if (p == 1) sb.append("#");
            if (p == 0) sb.append(" ");
            a /= 2;
        }
        while (sb.length() != n) {
            sb.append(" ");
        }
        return sb.reverse().toString();
    }
    
    
}