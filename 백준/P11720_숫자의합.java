import java.util.Scanner;

class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sNum = sc.next();
        int sum = 0;
        for (char c : sNum.toCharArray()) {
            sum += c - '0';
        }
        System.out.println(sum);
    }
}