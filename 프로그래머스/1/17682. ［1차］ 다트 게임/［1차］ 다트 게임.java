import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int first = 0, second = 0, third = 0;
        int check = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : dartResult.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            }
            if (c == 'S' || c == 'D' || c == 'T') {
                int num = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                check++;
                if (c == 'D') num *= num;
                if (c == 'T') num = num * num * num;
                if (first == 0) {
                    first = num;
                } else if (second == 0) {
                    second = num;
                } else {
                    third = num;
                }
            }
            if (c == '*') {
                if (check == 3) {
                    third *= 2;
                    second *= 2;
                } else if (check == 2) {
                    second *= 2;
                    first *= 2;
                } else {
                    first *= 2;
                }
            }
            if (c == '#') {
                if (check == 3) {
                    third *= -1;
                } else if (check == 2) {
                    second *= -1;
                } else {
                    first *= -1;
                }
            }
        }
        return first + second + third;
    }
}