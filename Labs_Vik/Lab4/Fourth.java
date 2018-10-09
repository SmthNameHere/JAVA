package lab4;
import java.util.Arrays;
import static view.Input.*;
import static view.Output.*;

/**
 * PACKAGE NAME: lab4
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */
public class Fourth {
    public static void main(String[] args) {
        int n = nextInt("Input number of tosses: ");
        Hort.solve(n);

        int num = nextInt("Input number to test: ");
        println(Perfect.solve(num));

        int number = nextInt("Number for reverse: ");
        Reverse.solve(number);

        int numb = nextInt("Input natural number: ");
        Numbers.solve(numb);

    }
}
