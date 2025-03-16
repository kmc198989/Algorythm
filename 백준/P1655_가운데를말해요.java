import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            int minSize = minHeap.size();
            int maxSize = maxHeap.size();

            if (maxSize > minSize + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minSize > maxSize) {
                maxHeap.add(minHeap.poll());
            }
            sb.append(maxHeap.peek()).append("\n");

        }
        System.out.println(sb);
    }
}
