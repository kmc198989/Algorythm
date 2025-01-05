import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        int len = prices.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int curprice = prices[i];
            
            while (!stack.isEmpty() && stack.peek()[0] > curprice) {
                int[] before = stack.pop();
                answer[before[1]] = i - before[1];
            }
            stack.push(new int[]{curprice, i});            
        }
        
        while (!stack.isEmpty()) {
            int[] price = stack.pop();
            answer[price[1]] = len - 1 - price[1];
        }
        
        return answer;
    }
}