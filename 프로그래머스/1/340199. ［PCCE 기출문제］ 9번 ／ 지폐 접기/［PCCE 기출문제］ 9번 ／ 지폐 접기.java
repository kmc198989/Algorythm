import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int larger = 0, smaller = 0;
        if (wallet[0] > wallet[1]) {larger = wallet[0]; smaller = wallet[1];}
        if (wallet[0] <= wallet[1]) {larger = wallet[1]; smaller = wallet[0];}
        
        while (true) {
            int l = 0, s = 0;
            if (bill[0] > bill[1]) {l = bill[0]; s = bill[1];}
            if (bill[0] <= bill[1]) {l = bill[1]; s = bill[0];}
            if (larger >= l && smaller >= s) break;
            bill[0] = l / 2; bill[1] = s;
            answer++;
        }
        
        return answer;
    }
}