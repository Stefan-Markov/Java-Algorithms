import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int sum = sumArr(arr, 0);
        System.out.println(sum);
    }
    private static int sumArr(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return sumArr(arr, index + 1) + arr[index];
    }
}
