import java.util.Scanner;

public class QueenOptimised {
    public static boolean isConsistent(int[] queen, int size) {

        for (int i = 0; i < size; i++) {
            if (queen[i] == queen[size]) return false;   // same column
            if ((queen[i] - queen[size]) == (size - i)) return false;   // same major diagonal
            if ((queen[size] - queen[i]) == (size - i)) return false;   // same minor diagonal
        }
        return true;
    }

    public static void printQueens(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void enumerate(int size) {
        int[] board = new int[size];
        enumerate(board, 0);
    }

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) printQueens(q);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k + 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int boardSize = Integer.parseInt(scan.nextLine());
        enumerate(boardSize);
    }
}
