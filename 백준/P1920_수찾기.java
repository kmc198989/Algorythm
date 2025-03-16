import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int findNum = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = A.length;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (findNum > A[mid]) {
                    left = mid+1;
                }
                if (findNum < A[mid]) {
                    right = mid;
                }
                if (findNum == A[mid]) {
                    sb.append(1).append("\n");
                    break;
                }
                if (left == right && findNum != A[mid]) {
                    sb.append(0).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
