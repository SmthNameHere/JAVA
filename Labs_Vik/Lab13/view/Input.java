package by.bntu.fitr.povt.javanutie.console;

import java.util.Scanner;

public class Input {
    public static int nextInt(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextInt();
    }

    public static double nextDouble(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextDouble();
    }

    public static String nextLine(String msg) {
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }
}
