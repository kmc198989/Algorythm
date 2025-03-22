import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;        
        
        int length = triangle.length;
        int[][] dp = new int[length][length];
        
        for (int i = 0; i < length - 1; i++) {
            int len = triangle[i].length;
            for (int j = 0; j < len; j++) {
                int cur = Math.max(triangle[i][j], dp[i][j]);
                dp[i+1][j] = Math.max(dp[i+1][j], triangle[i+1][j] + cur);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], triangle[i+1][j+1] + cur);
            }
        }
        
        for (int n : dp[length - 1]) {
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}