import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedAreasIMatrix {
    public static char[][] matrix;
    public static List<int[]> area;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int r = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());

        matrix = new char[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = scan.nextLine().toCharArray();
        }

        area = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '-') {
                    area.add(new int[]{row, col, 0});
                    findAreas(row, col);
                }
            }
        }

        System.out.println("Total areas found: " + area.size());

        AtomicInteger lambda = new AtomicInteger(1);

        area.stream().sorted((s1, s2) -> Integer.compare(s2[2], s1[2]))
                .forEach(a -> {
                    System.out.println("Area #" + lambda.getAndIncrement() + " at (" +
                            a[0] + ", " + a[1] + "), size: " + a[2]);

                });
    }

    private static void findAreas(int row, int col) {
        if (isOutOfBounds(row, col) || isNotAble(row, col)) {
            return;
        }
        matrix[row][col] = 'V';
        area.get(area.size() - 1)[2]++;

        findAreas(row + 1, col);
        findAreas(row, col + 1);
        findAreas(row - 1, col);
        findAreas(row, col - 1);
    }

    private static boolean isNotAble(int row, int col) {
        return matrix[row][col] == 'V' || matrix[row][col] == '*';
    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}