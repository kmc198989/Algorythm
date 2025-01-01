import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int num : arr) {
            if (num != stack.peek()) stack.push(num);
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}