import java.util.ArrayList;
import java.util.Scanner;

public class Calculator extends Operations{

    public static void main(String[] args) {
        Double[] vals = new Double[];
        Scanner input = new Scanner(System.in);
        String exp = input.nextLine();
        System.out.println(calc(exp));
        input.close();
    }

    public static double calc(String str) {
        String[] exp = str.split(" ");
        for (int i = exp.length - 1; i>=0; i--) {

        }
    }
}
