import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] dp = new int[K + 1]; // 배낭의 최대 가치 저장 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 물건의 무게
            int V = Integer.parseInt(st.nextToken()); // 물건의 가치

            // **배낭 용량을 역순으로 업데이트 (중복 사용 방지)**
            for (int w = K; w >= W; w--) {
                dp[w] = Math.max(dp[w], dp[w - W] + V);
            }
        }

        System.out.println(dp[K]); // 최대 가치 출력
    }
}
