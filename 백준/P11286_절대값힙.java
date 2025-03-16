import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P11286_절대값힙 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absa = Math.abs(a);
            int absb = Math.abs(b);
            return absa == absb ? a - b : absa - absb;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(num);
            } else {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
