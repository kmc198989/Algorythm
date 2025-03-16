import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298_오큰수 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] A = new int[N+1];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
