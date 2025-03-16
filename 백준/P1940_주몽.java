import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int l = 0, r = A.length-1;
        int count = 0;
        while(l < r) {
            int sum = A[l] + A[r];
            if (sum == M) {
                count++;
                l++;
                r--;
            } else if (sum > M) {
                r--;
            } else {
                l++;
            }
        }
        bw.write(String.valueOf(count) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
