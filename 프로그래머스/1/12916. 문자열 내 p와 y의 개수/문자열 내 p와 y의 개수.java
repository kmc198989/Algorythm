import java.util.*;

class Solution {
    boolean solution(String s) {
        int countC = 0, countS = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {countC++; continue;}
            if (c == 'y' || c == 'Y') {countS++; continue;}
        }
        if (countC == countS) return true;
        
        return false;
    }
}