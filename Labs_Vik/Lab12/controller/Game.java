package by.bntu.fitr.povt.javanutie.controller;

import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.container.utils.Baskets;
import by.bntu.fitr.povt.javanutie.model.container.utils.ContainersCreator;
import by.bntu.fitr.povt.javanutie.model.container.utils.comparators.*;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static by.bntu.fitr.povt.javanutie.console.Print.*;
import static by.bntu.fitr.povt.javanutie.console.Input.*;

public class Game {
    private static final Creator creator;
    private static ComparatorsMap comparators;
    private static ContainersCreator containersCreator;
    private static Container<Gadget> basket;

    static {
        creator = Creator.CREATOR;
        containersCreator = ContainersCreator.CONTAINERS_CREATOR;

        comparators = new ComparatorsMap();
        comparators.addComparator(ComparatorsMap.ComparatorTypes.PRICE_ASC,
                new GadgetPriceAscComparator());
        comparators.addComparator(ComparatorsMap.ComparatorTypes.PRICE_DESC,
                new GadgetPriceDescComparator());
        comparators.addComparator(ComparatorsMap.ComparatorTypes.PRESTIGE_ASC,
                new GadgetPrestigeAscComparator());
        comparators.addComparator(ComparatorsMap.ComparatorTypes.PRESTIGE_DESC,
                new GadgetPrestigeDescComparator());
        comparators.addComparator(ComparatorsMap.ComparatorTypes.PRICE_PRESTIGE_ASC,
                new GadgetPriceAscComparator().thenComparing(
                        new GadgetPrestigeAscComparator()
                ));
    }

    public static void main(String[] args) {
        println(containersCreator);
        String type = nextLine("Enter container: ");
        basket = containersCreator.getContainer(type);
        println();

        addPowerbank();
        addPowerbank();
        addPowerbank();
//        addPowerbank();

        println("\nYour basket: ");
        println(basket);

        Basket<Gadget> test = new Basket<>();
        for(Gadget gadget : basket) { // демонстрация работы foreach для своих типов
            test.add(gadget);
        }

        println("\nSorted basket: ");
        Collections.sort(test.getList()); // демонстрация работы нативной сортировки
        println(test);

        println("\nAvailable sorted types: ");
        println(comparators);
        type = nextLine("Enter type: ");
        // демонстрация работы сортировки с использованием компараторов
        test.getList().sort(comparators.getComparator(type));
        println("Your basket: ");
        println(test);
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
