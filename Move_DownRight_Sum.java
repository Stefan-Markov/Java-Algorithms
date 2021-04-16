import java.util.*;

public class Move_DownRight_Sum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        int[][] elements = new int[rows][cols];

        for (int row = 0; row < elements.length; row++) {
            elements[row] = Arrays.stream(scan.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] table = new int[rows][cols];


        table[0][0] = elements[0][0];

        for (int col = 1; col < cols; col++) {
            table[0][col] = table[0][col - 1] + elements[0][col];
        }

        for (int row = 1; row < rows; row++) {
            table[row][0] = table[row - 1][0] + elements[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                table[row][col] =
                        Math.max(table[row - 1][col] + elements[row][col],
                                table[row][col - 1] + elements[row][col]);
            }
        }


        int row = rows - 1;
        int col = cols - 1;
        List<String> path = new ArrayList<>();

        path.add(formatOutput(row, col));

        while (row > 0 || col > 0) {

            int top = -1;
            if (row > 0) {
                top = table[row - 1][col];
            }

            int left = -1;
            if (col > 0) {
                left = table[row][col - 1];
            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            path.add(formatOutput(row, col));
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}
