import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047_동전0 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] A = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            count += (K / A[i]);
            K = K % A[i];
        }

        System.out.println(count);



    }
}
