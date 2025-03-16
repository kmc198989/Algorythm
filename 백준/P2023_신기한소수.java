import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class P2023_신기한소수 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= 9; i++) {
            dfs(i, N, sb, 1);
        }
        System.out.println(sb);

    }

    public static void dfs (int num, int N, StringBuilder sb, int depth) {
        if (depth == N && isPrime(num)) {
            sb.append(num).append("\n");
            return;
        }
        if (!isPrime(num)) return;
        for (int i = 1; i <= 9; i += 2) {
            int nnum = num * 10 + i;
            dfs(nnum, N, sb, depth + 1);
        }

    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
