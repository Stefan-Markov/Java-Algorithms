import java.util.Scanner;

public class CombinationsWithoutRepetition {
    public static String[] elements;
    public static String[] variations;
    public static boolean[] used;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        elements = scan.nextLine().split(" ");
        variations = new String[Integer.parseInt(scan.nextLine())];
        used = new boolean[elements.length];


        combinations(0, 0);
    }

    private static void combinations(int index, int start) {

        if (index == variations.length) {
            print(variations);
        } else {
            for (int i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index + 1, i + 1);
            }
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}

