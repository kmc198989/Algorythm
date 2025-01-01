import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int day = cal(progresses[0], speeds[0]);
        int count = 0;
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int curday = cal(progress, speed);
            if (day >= curday) {
                count++;
                continue;
            }
            if (day < curday) {
                day = curday;
                result.add(count);
                count = 1;
            }
        }
        result.add(count);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    private int cal(int progress, int speed) {
        return (100 - progress + speed - 1) / speed;
    }
}