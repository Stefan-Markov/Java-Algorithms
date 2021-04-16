import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        long result = fact(n);

        System.out.println(result);
    }
    private static long fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}

