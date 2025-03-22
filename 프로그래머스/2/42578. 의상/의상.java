import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String name = cloth[0];
            String wear = cloth[1];
            map.put(wear, map.getOrDefault(wear, 0) + 1);
        }
        
        for (int n : map.values()) {
            answer *= (n + 1);
        }
        
        return answer - 1;
    }
}