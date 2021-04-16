import java.util.Scanner;

public class VariationsWithoutRepetition {
    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split(" ");
        variations = new String[Integer.parseInt(scan.nextLine())];
        used = new boolean[elements.length];

        variations(0);
    }

    private static void variations(int index) {
        if (index == variations.length) {
            print(variations);
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;

                variations[index] = elements[i];

                variations(index + 1);

                used[i] = false;
            }
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}

