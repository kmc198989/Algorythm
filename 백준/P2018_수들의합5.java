import java.io.*;
import java.util.StringTokenizer;

public class P2018_수들의합5 {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int startnum = 1;
        int endnum = 1;
        int sum = 1;
        int count = 1;

        while (endnum != N) {
            if (sum == N) {
                count++;
                endnum++;
                sum = sum + endnum;
            } else if (sum > N) {
                sum = sum - startnum;
                startnum++;
            } else {
                endnum++;
                sum = sum + endnum;
            }
        }

        bw.write(String.valueOf(count)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
