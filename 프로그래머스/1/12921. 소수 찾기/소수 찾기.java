public class Solution {
    public int solution(int n) {
        boolean[] isComposite = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                count++;
                for (int j = i * 2; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        return count;
    }
}
