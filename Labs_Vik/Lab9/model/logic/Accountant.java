package by.bntu.fitr.povt.javanutie.model.logic;

import by.bntu.fitr.povt.javanutie.model.container.Basket;

public class Accountant {
    public static double calcPrice(Basket basket) {
        int size = basket.size();
        double price = 0.0;
        for (int i = 0; i < size; i++) {
            price += basket.get(i).getPrice();
        }
        return price;
    }

    public static double caclAverageRating(Basket basket) {
        double size = basket.size();
        double average = 0.0;
        for (int i = 0; i < size; i++) {
            average += basket.get(i).getPrestige();
        }
        average /= size;
        return average;
    }
}
