import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++) {
            dp.get(i).add(getConcatNumber(N, i));
            
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) {
                            dp.get(i).add(a / b);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
    
    private int getConcatNumber(int N, int count) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result = result * 10 + N;
        }
        return result;
    }
}
