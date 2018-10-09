package by.bntu.fitr.povt.javanutie.controller;

import by.bntu.fitr.povt.javanutie.model.container.ContainersCreator;
import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;

import java.util.Arrays;

import static by.bntu.fitr.povt.javanutie.console.Print.*;
import static by.bntu.fitr.povt.javanutie.console.Input.*;

public class Game {
    private static final Creator creator;
    private static final ContainersCreator containers;
    private static Container<Gadget> basket;

    static {
        creator = Creator.CREATOR;
        containers = ContainersCreator.CONTAINERS_CREATOR;
    }

    public static void main(String[] args) {
        println(containers);
        String type = nextLine("Enter container: ");
        basket = containers.getContainer(type);
        println();

        addPowerbank();
        addPowerbank();

        println("\nYour basket: ");
        println(basket);
    }

    public static void addPowerbank() {
        Powerbank gadget = creator.createPowerbank();
        gadget.setPrice(nextDouble("Enter price (double): "));
        gadget.setPrestige(nextDouble("Enter prestige (double): "));

        println("Available colors: ");
        println(Arrays.toString(Powerbank.Color.values()));
        String color = nextLine("Enter color: ").toUpperCase();
        gadget.setColor(Powerbank.Color.valueOf(color));
        gadget.setCapacity(nextInt("Enter capacity (int):"));

        println("** Success **");
        basket.add(gadget);
    }
}
