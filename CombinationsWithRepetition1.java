import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsWithRepetition1 {
    public static int[] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        arr = new int[k];

        combination(0, 1);
    }

    public static void combination(int index, int start) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combination(index + 1, i);
            }
        }
    }

    private static void printArr() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}