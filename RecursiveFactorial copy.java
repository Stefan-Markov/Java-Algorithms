import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        long result = calculationFactorial(n);

        System.out.println(result);
    }

    private static long calculationFactorial(int n) {
        if (n == 1) {
            return 1;

        }

        return n * calculationFactorial(n - 1);
    }
}
