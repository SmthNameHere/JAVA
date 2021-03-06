package lab4;

/**
 * PACKAGE NAME: lab4
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */

//Натуральное число называют совершенным, если оно равно сумме всех своих
//делителей, не считая только его самого (например,28=1+2+3+7+14–совер-шенное число).
//Напишите программу, которая организует диалог с пользова-телем и проверяет,
//является ли введённое натуральное число совершенным. 6 28 496 8128
public class Perfect {
    public static String solve(int num) {
        int temp = 0;
        if (num % 2 == 0) {
            for (int i = 1; i < num; i++) {
                if (num % i == 0) {
                    temp += i;
                }
            }
        }
        if (temp == num) {
            return "Число: " + num + " - совершенное";
        }
        return "Число: " + num + " - не совершенное";
    }
}
