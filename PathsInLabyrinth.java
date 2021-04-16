import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth {
    public static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] labyrinth = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            labyrinth[i] = scan.nextLine().toCharArray();
        }
        findPath(labyrinth, 0, 0, ' ');
    }

    private static void findPath(char[][] matrix, int row, int col, char direction) {

        if (!isInBounds(matrix, row, col) || matrix[row][col] == 'V'
                || matrix[row][col] == '*') {
            return;
        }

        path.add(direction);

        if (matrix[row][col] == 'e') {
            printPath();
            path.remove(path.size() - 1);
            return;
        }
        matrix[row][col] = 'V';
        try {
            findPath(matrix, row - 1, col, 'U');
            findPath(matrix, row + 1, col, 'D');
            findPath(matrix, row, col + 1, 'R');
            findPath(matrix, row, col - 1, 'L');
        } catch (IndexOutOfBoundsException ex) {

        }
        matrix[row][col] = '-';

        path.remove(path.size() - 1);
    }

    private static void printPath() {

        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && row < matrix[row].length;
    }
}
