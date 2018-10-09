package lab4;
/**
 * PACKAGE NAME: lab4
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */

//Напишите программу, которая организует диалог с пользователем и с помощью соответствующих
//арифметических операций для натурального числа N
//вычисляет число M, записываемое теми же цифрами, что и N, но в обратном
//порядке (все незначащие нули в числе M не выводятся, например, если N =
//2900, то M=92)
public class Reverse {
    public static void solve(int number){
        StringBuilder nums = new StringBuilder();
        int del = 10;
        int num;
        while ((num = number % del) != 0) {
            nums.append(num);
            number = (number - num) / del;
        }
        view.Output.println(nums);
    }
}
