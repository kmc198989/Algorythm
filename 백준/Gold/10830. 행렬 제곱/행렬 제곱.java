import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long B;
    static final int MOD = 1000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }
        
        int[][] result = power(A, B);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    // 분할 정복을 이용하여 행렬 A의 B제곱을 계산하는 메서드
    static int[][] power(int[][] A, long b) {
        if (b == 1) return A;
        int[][] half = power(A, b / 2);
        int[][] result = multiply(half, half);
        if (b % 2 == 1) {
            result = multiply(result, A);
        }
        return result;
    }
    
    // 두 행렬 A와 B의 곱을 계산하는 메서드 (모든 연산 후 MOD로 나눈 나머지)
    static int[][] multiply(int[][] A, int[][] B) {
        int[][] C = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}
