package lab3;

public class QuadraticEquation {
    public static String solve(int a, int b, int c) {
    String result = "Error";
    if (a != 0) {
        double D = b*b-4*a*c;
        if (D > 0){
            double x1 = (-b+Math.sqrt(D)/(2*a));
            double x2 = (-b+Math.sqrt(D)/(2*a));
            result = "2 roots : " +x1 +"and "+ x2;
        } else if (D == 0) {
            double x = - Math.sqrt(c);
            result = "only 1 root : "+x;
        }
        else {
            result = "No roots";
        }

    }
    return result;
} }
