package view;

/**
 * PACKAGE NAME: lab4
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */

import java.util.Scanner;

public class Input {

    public static String string(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }

    public static Integer nextInt(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextInt();
    }

}