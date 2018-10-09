package by.bntu.fitr.povt.javanutie.console;

public class Print {
    public static void println(Object o) {
        System.out.println(o);
    }

    public static void println() {
        System.out.println(" ");
    }

    public static void print(Object o) {
        System.out.print(o);
    }

    public static void printf(String format, Object... objects) {
        System.out.printf(format, objects);
    }
}
