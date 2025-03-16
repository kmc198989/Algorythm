import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1300_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 이진 탐색의 범위를 설정
        int left = 1;
        int right = k;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (countLessEqual(N, mid) >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    // 중간 값 이하의 수의 개수를 계산하는 함수
    private static int countLessEqual(int N, int x) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count += Math.min(x / i, N);
        }
        return count;
    }
}
