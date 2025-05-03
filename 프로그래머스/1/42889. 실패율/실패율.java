import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] notCleared = new int[N + 2];
        int users = stages.length;
        
        List<Stage> result = new ArrayList<>();
        
        for (int num : stages) {notCleared[num]++;}    
        
        for (int i = 1; i <= N; i++) {
            result.add(new Stage(i, notCleared[i], users));
            users -= notCleared[i];
        }
        
        Collections.sort(result, (a, b) -> {
            return Double.compare(b.percent, a.percent);
        });
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i).stagenum;
        }
        
        return answer;
    }
    
    class Stage {
        int stagenum;
        double percent;
        
        Stage(int stagenum, int notClear, int clear) {
            this.stagenum = stagenum;
            if (clear == 0) {
                this.percent = 0;
            } else {
                this.percent = (double) notClear / clear;    
            }            
        }
    }
    
    
}