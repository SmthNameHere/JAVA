package lab3;

public class Third {
    public static void main(String[] args) {
        view.Output.print("Zadacha o drakone\n");
        int n = view.Input.nextInt("Input number of years:");
        view.Output.println(Drakon.solve(n));

        view.Output.print("Quadratic equation : ax^2+bx+c \n");
        int a = view.Input.nextInt("input a: ");
        int b = view.Input.nextInt("input b: ");
        int c = view.Input.nextInt("input c: ");
        view.Output.println(QuadraticEquation.solve(a, b, c));

        MoodSensor.solve();
        Dice.solve();

        String d = view.Input.string("Input letter: ");
        Word.solve(d.charAt(0));

    }
}
