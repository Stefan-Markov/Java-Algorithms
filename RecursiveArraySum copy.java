import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        sum = sumRecursion(arr, arr.length - 1);

        System.out.println(sum);
    }

    private static int sumRecursion(int[] arr, int index) {
        if (index < 0) {
            return 0;
        }
        return arr[index] + sumRecursion(arr, index - 1);
    }
}

