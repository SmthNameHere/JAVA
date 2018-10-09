package by.bntu.fitr.povt.javanutie.controller;

import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.logic.Accountant;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;

import static by.bntu.fitr.povt.javanutie.console.Print.*;

public class Game {
    public static void main(String[] args) {
        Basket basket = new Basket();
        Creator creator = new Creator();

        basket.add(creator.createPowerbank(12.00, 4.5, "blue", 300));
        basket.add(creator.createPhone(300, 3.0, "snapdragon 865", 4.5));
        basket.add(creator.createPowerbank(40.50, 5.0, "black", 12000));
        basket.add(creator.createPowerbank(100, 5.0, "black", 36000));
        basket.add(creator.createPhone(450, 4.5, "kirin 400", 5.5));

        println("Your basket: ");
        println(basket);

        println("General cost: " + Accountant.calcPrice(basket));
        println("Average rating: " + Accountant.caclAverageRating(basket));
    }
}
