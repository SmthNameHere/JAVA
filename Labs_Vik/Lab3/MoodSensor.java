package lab3;
//Напишите программу «Mood Sensor» (эмулировать датчика настроения),
//которая «залазит» в душу пользователя и определяет его настроение в текущий
//момент времени. Приложение будет генерировать случайное число,
//в зависимости от значения которого на экран выводится одно из псевдографических
//«лиц», которое и будет отображать настроение пользователя.

import java.util.Random;

public class MoodSensor {
    public static void solve() {
        Random random = new Random();
        int pos = random.nextInt(5) + 1;
        switch (pos) {
            case 1 : view.Output.println("your mood: -_- "); break;
            case 2 : view.Output.println("your mood: :0 "); break;
            case 3 : view.Output.println("your mood: :) "); break;
            case 4 : view.Output.println("your mood: :( "); break;
            case 5 : view.Output.println("your mood: !_! "); break;
        }
    }
}
