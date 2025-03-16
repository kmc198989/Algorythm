import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int next = 1;
        for (int j = 0; j < N; j++) {
            int num = A[j];
            if (num >= next) {
                while (num >= next) {
                    stack.push(next++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.isEmpty() || stack.peek() != num) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}
