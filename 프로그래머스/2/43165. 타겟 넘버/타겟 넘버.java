import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length;
        
        answer = dfs(numbers, len, target, 0, 0);        
        
        return answer;
    }
    
    private int dfs(int[] numbers, int length, int target, int num, int count) {
        if (count == length && num == target) return 1;
        if (count == length) return 0;
        
        int result = 0;
        
        result += dfs(numbers, length, target, num + numbers[count], count + 1);
        result += dfs(numbers, length, target, num - numbers[count], count + 1);
        
        return result;
    }
}