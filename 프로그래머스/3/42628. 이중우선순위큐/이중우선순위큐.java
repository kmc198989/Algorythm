import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pqmin = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        
        for (String operation : operations) {
            String[] oper = operation.split(" ");
            String order = oper[0];
            int num = Integer.parseInt(oper[1]);
            
            if (order.equals("I")) {
                pqmin.add(num);
                pqmax.add(num);
                continue;
            }  

            if (pqmin.isEmpty()) {
                pqmin.clear();
                pqmax.clear();
            }
            if (num == -1) {
                pqmax.remove(pqmin.poll());
                continue;
            }
            
            if (num == 1) {
                pqmin.remove(pqmax.poll());
                continue;
            }
        }
        
        answer[0] = pqmax.isEmpty() ? 0 : pqmax.peek();
        answer[1] = pqmin.isEmpty() ? 0 : pqmin.peek();
        
        return answer;
    }
}