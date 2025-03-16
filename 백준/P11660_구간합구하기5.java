import java.io.*;
import java.util.StringTokenizer;

public class P11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[][] matrix = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int k = 0; k < M; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());

            int res = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
            result.append(res).append("\n");
        }

        bufferedWriter.write(result.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
