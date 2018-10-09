package lab3;
//Напишите программу, которая бы эмулировала игру«Dice»(игра в кости).
//Суть игры заключается в броске двух шестигранных кубиков
//(костей) и подсчёта общей суммы очков, которые выпали на первой и второй костей

import java.util.Random;

public class Dice {
    public static void solve() {
        Random random = new Random();
        int first = random.nextInt(6) + 1;
        int second = random.nextInt(6) + 1;
        int result = first + second;
        view.Output.println("DICE GAME: Your result : "+result);
    }
}
