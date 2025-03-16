import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long startTime = System.currentTimeMillis(); // 시작 시간 측정

        Arrays.sort(A);

        int count = 0;
        for (int cur = 0; cur < N; cur++) {
            int curnum = A[cur];
            int l = 0, r = N - 1;

            while (l < r) {
                if (l == cur) {
                    l++;
                    continue;
                }
                if (r == cur) {
                    r--;
                    continue;
                }
                int sum = A[l] + A[r];
                if (sum == curnum) {
                    count++;
                    break;
                } else if (sum > curnum) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        System.out.println(count);
        br.close();
        long endTime = System.currentTimeMillis(); // 종료 시간 측정
        System.out.println("Execution time: " + (endTime - startTime) + " ms");

    }
}
