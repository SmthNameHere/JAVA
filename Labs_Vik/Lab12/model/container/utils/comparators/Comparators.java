package by.bntu.fitr.povt.javanutie.model.container.utils.comparators;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.Arrays;
import java.util.Comparator;

public enum Comparators {
    PRICE_ASC(new GadgetPriceAscComparator()),
    PRICE_DESC(new GadgetPriceDescComparator()),
    PRESTIGE_ASC(new GadgetPrestigeAscComparator()),
    PRESTIGE_DESC(new GadgetPrestigeDescComparator()),
    PRICE_PRESTIGE_ASC(new GadgetPriceAscComparator().thenComparing(
            new GadgetPrestigeAscComparator()));

    private Comparator<Gadget> comparator;

    Comparators(Comparator<Gadget> comparator){
        this.comparator = comparator;
    }

    public Comparator<Gadget> getComparator() {
        return comparator;
    }

    @Override
    public String toString() {
        return Arrays.toString(Comparators.values());
    }
}
