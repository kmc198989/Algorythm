import java.io.*;
import java.util.StringTokenizer;

class P11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        long[] prefixSum = new long[N + 1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < M; j++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            result.append(prefixSum[end] - prefixSum[start - 1]).append("\n");
        }

        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
