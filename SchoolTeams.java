import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {

    public static String[] boys;
    public static String[] boysCombination = new String[2];
    public static String[] girl;
    public static String[] girlComtionation = new String[3];
    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        girl = scan.nextLine().split(", ");
        boys = scan.nextLine().split(", ");

        combineGirls(0, 0);
        combineBoys(0, 0);

        for (String girls : allGirls) {
            for (String boy : allBoys) {
                System.out.println(girls + ", " + boy);
            }
        }
    }

    private static void combineGirls(int index, int start) {

        if (index == girlComtionation.length) {

            allGirls.add(String.join(", ", girlComtionation));
        } else {

            for (int i = start; i < girl.length; i++) {
                girlComtionation[index] = girl[i];
                combineGirls(index + 1, i + 1);
            }
        }
    }

    private static void combineBoys(int index, int start) {

        if (index == boysCombination.length) {

            allBoys.add(String.join(", ", boysCombination));
        } else {

            for (int i = start; i < boys.length; i++) {
                boysCombination[index] = boys[i];
                combineBoys(index + 1, i + 1);
            }
        }
    }
}
