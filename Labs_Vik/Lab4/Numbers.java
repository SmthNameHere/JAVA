package lab4;
/**
 * PACKAGE NAME: lab4
 * CREATED BY: *JAVAнутые*
 * PROJECT NAME: NaGugl
 * VERSION: 1.0.0
 */
//Разработать наиболее эффективные алгоритмы и написать код для решения
//следующих задач:
//  - найти сумму и количество цифр у заданного натурального числа;
//  - найти количество различных цифр у заданного натурального числа;
//  - найти наибольшую цифру натурального числа;
//  - задано натуральное число, проверить, является ли оно палиндромом;
//  - определить является ли заданное натуральное число простым;
//  - найти все простые делители заданного натурального числа;
//  - найти НОД и НОК двух натуральных чисел a и b
public class Numbers {
    public static void solve(int number) {

        String str = number + "";
        char[] strNums = str.toCharArray();
        int[] nums = new int[strNums.length];
        String dels = "";
        int sum = 0;
        int max = 0;
        boolean isSimple = false;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Character.getNumericValue(strNums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] > nums[i+1]) {
                    max = nums[i];
            }
        }
        if (number%2 != 0 & number%3 != 0 & number%5 != 0) {
                isSimple = true;
        }
        for (int i = 1; i < number; i++) {
            if (number%i == 0) {
               dels += ","+i;
            }
        }
        view.Output.println("Количество цифр числа: " + nums.length +
                            "\nСумма всех цифр числа: "+ sum +
                            "\nНаибольшая цифра числа: "+ max +
                            "\nЯвляется ли проcтым: "+ isSimple+
                            "\nДелители:"+dels);

    }
}
