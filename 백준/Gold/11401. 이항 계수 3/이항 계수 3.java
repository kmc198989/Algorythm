import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(bionomial(n, k));
    }

    static long bionomial(int n, int k) {
        long[] fact = new long[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i-1] * i) % MOD;
        }

        // 분모
        long bunmo = (fact[k] * fact[n - k]) % MOD;
        
        return (fact[n] * modPow(bunmo, MOD - 2)) % MOD;
    }

    static long modPow(long a, int b) {
        long result = 1;
        a = a % MOD;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }
}
