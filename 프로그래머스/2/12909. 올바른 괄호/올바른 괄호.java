import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == ')') return false;
            if (c == '(') stack.push(c);
            if (c == ')') stack.pop();
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}