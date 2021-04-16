import java.util.Scanner;

public class Fibonacci {
    public static long[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        dp = new long[n + 1];

        long fib = calcFibonacci(n);
        System.out.println(fib);
    }

    private static long calcFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = calcFibonacci(n - 1) + calcFibonacci(n - 2);
    }
}
