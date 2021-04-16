import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(scan.nextLine());

        System.out.println(indexOf(arr, key));
    }

    private static int indexOf(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int curr = arr[mid];
            if (key < curr) {
                end = mid - 1;

            } else if (key > curr) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
