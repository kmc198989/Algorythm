import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int start = command[0]-1;
            int end = command[1]-1;
            int n = command[2]-1;
            
            int[] tempArray = new int[end - start + 1];
            for (int i = 0; i < tempArray.length; i++) {
                tempArray[i] = array[i + start];
            }
            Arrays.sort(tempArray);
            answer[idx++] = tempArray[n];
        }
        
        return answer;
    }
}