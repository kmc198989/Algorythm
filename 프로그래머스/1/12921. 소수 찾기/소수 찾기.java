import java.util.*;

class Solution {
    boolean[] all;
    public int solution(int n) {
        int answer = 0;
        all = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    private boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}