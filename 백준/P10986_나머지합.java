import java.io.*;
import java.util.StringTokenizer;

public class P10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sum = new long[N + 1];
        long[] count = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
            int div = (int) (sum[i] % M);
            if (div == 0) {
                answer++;
            }
            count[div]++;
        }


        for (int i = 0; i < M; i++) {
            if (count[i] > 1) {
                answer += (count[i] * (count[i] - 1)) / 2;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
