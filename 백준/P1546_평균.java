import java.util.Scanner;

public class P1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
            max = Math.max(max, score[i]);
            sum += score[i];
        }
        System.out.println((double)sum * 100 / (max * N));

    }
}
