package by.bntu.fitr.povt.javanutie.controller;

import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;
import by.bntu.fitr.povt.javanutie.model.logic.Accountant;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;

import java.util.Arrays;

import static by.bntu.fitr.povt.javanutie.console.Print.*;
import static by.bntu.fitr.povt.javanutie.console.Input.*;

public class Game {
    public static void main(String[] args) {
        Creator creator = Creator.CREATOR;

        Powerbank gadget = creator.createPowerbank();
        println("Your gadget: " + gadget);

        gadget.setPrice(nextDouble("Enter price (double): "));
        gadget.setPrestige(nextDouble("Enter prestige (double): "));

        println("Available colors: ");
        println(Arrays.toString(Powerbank.Color.values()));
        String color = nextLine("Enter color: ").toUpperCase();
        gadget.setColor(Powerbank.Color.valueOf(color));
        gadget.setCapacity(nextInt("Enter capacity (int):"));

        println("\nYour gadget: ");
        println(gadget);
    }
}
