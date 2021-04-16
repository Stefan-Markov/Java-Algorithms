import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        LocalDateTime now = LocalDateTime.now();

        System.out.println(dtf.format(now));
        int n = Integer.parseInt(scan.nextLine());
        System.out.println(fibonacci(n));
        System.out.println(java.time.LocalTime.now());
    }

    private static long fibonacci(int i) {
        if (i <= 1)
            return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}
