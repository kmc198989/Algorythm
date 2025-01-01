import java.util.*;

class Solution {
    public int solution(int bridge_length, int maxWeight, int[] truck_weights) {
        Queue<Integer> waitingQueue = new LinkedList<>();
        Queue<Integer> onBridgeQueue = new LinkedList<>();
        
        for (int truckWeight : truck_weights) {
            waitingQueue.add(truckWeight);
        }
        
        for (int i = 0; i < bridge_length; i++) {
            onBridgeQueue.add(0);
        }
        
        int time = 0;
        int currentWeightOnBridge = 0;
        
        while (!waitingQueue.isEmpty()) {
            time++;
            
            currentWeightOnBridge -= onBridgeQueue.poll();
            
            if (!waitingQueue.isEmpty() && currentWeightOnBridge + waitingQueue.peek() <= maxWeight) {
                int truck = waitingQueue.poll();
                currentWeightOnBridge += truck;
                onBridgeQueue.add(truck);
            } else {
                onBridgeQueue.add(0);
            }
        }
        
        return time + bridge_length;
    }
}
