import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P11003_최솟값찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<Node> dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int curnum = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.getLast().value > curnum) {
                dq.removeLast();
            }

            dq.addLast(new Node(curnum, i));

            while (dq.getFirst().index <= i - L) {
                dq.removeFirst();
            }
            bw.write(dq.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
