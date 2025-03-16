import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_기타레슨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의 수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 수

        int[] lessons = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            if (lessons[i] > max) max = lessons[i];
            sum += lessons[i];
        }

        // 이진 탐색
        int left = max;
        int right = sum;
        int result = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canDivide(lessons, M, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDivide(int[] lessons, int M, int size) {
        int count = 1; // 블루레이 개수
        int sum = 0;
        for (int lesson : lessons) {
            if (sum + lesson > size) {
                count++;
                sum = lesson;
                if (count > M) {
                    return false;
                }
            } else {
                sum += lesson;
            }
        }
        return true;
    }
}
