import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MonkeyBusiness {

    public static int counter = 0;
    public static int n;
    public static int[] expression;
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        var reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        expression = new int[n];

        combinationsWithoutRep(0, 1);

        builder.append("Total Solutions: ").append(counter);
        System.out.print(builder);
    }

    private static void combinationsWithoutRep(int index, int start) {
        if (index >= n) {
            printSolution();
        } else {
            for (int i = start; i <= n; i++) {
                expression[index] = i;
                combinationsWithoutRep(index + 1, i + 1);
                expression[index] = -i;
                combinationsWithoutRep(index + 1, i + 1);
            }
        }
    }

    private static void printSolution() {
        int sum = Arrays.stream(expression).sum();
        if (sum == 0) {
            counter++;
            for (int j : expression) {
                String numberAsStr = j > 0 ? "+" + j : String.valueOf(j);
                builder.append(numberAsStr).append(" ");
            }
            builder.append(System.lineSeparator());
        }
    }
}
