package lab4;
//Написать программу «Heads or Tails?»(Орёл или решка?), которая бы «подбрасывала»
//условно монету, к примеру, 1000 раз и сообщала, сколько раз вы-пал орёл, а сколько–решка.

/**
 * PACKAGE NAME: lab4
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */

import java.util.Random;

public class Hort {
    public static void solve(int n) {
        Random random = new Random();
        int bird = 0;
        int rib = 0;
        for (int i = 0; i < n; i++) {
            boolean temp = random.nextBoolean();
            if (temp) {
                bird++;
            } else rib++;
        }
        view.Output.println("Heads: " + bird + " and Tails: " + rib);
    }
}
