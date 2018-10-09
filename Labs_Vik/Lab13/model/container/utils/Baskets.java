package by.bntu.fitr.povt.javanutie.model.container.utils;

import by.bntu.fitr.povt.javanutie.model.container.Basket;

import java.util.Comparator;

public class Baskets {
    public static <E> void sort(Basket<E> basket, Comparator<E> comparator) {
        basket.getList().sort(comparator);
    }
}
