import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] C = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int l = 0, r = P - 1;
        int count = 0;
        int[] F = new int[100];
        for (int i = 0; i < P; i++) {
            char cha = C[i];
            F[cha]++;
        }

        while (r < S) {
            if (F['A'] >= a && F['C'] >= c && F['G'] >= g && F['T'] >= t) {
                count++;
            }
            F[C[l]]--;
            l++;
            r++;
            if (r < S) {
                F[C[r]]++;
            }

        }
        System.out.println(count);
    }
}
