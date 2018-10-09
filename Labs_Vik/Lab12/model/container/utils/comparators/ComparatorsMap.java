package by.bntu.fitr.povt.javanutie.model.container.utils.comparators;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ComparatorsMap {
    private Map<ComparatorTypes, Comparator<Gadget>> comparators;

    public ComparatorsMap() {
        comparators = new HashMap<>();
    }

    public ComparatorsMap(Map<ComparatorTypes, Comparator<Gadget>> comparators) {
        this.comparators = comparators;
    }

    public enum ComparatorTypes {
        PRICE_ASC,
        PRICE_DESC,
        PRESTIGE_ASC,
        PRESTIGE_DESC,
        PRICE_PRESTIGE_ASC;
    }

    public Map<ComparatorTypes, Comparator<Gadget>> getComparators() {
        return comparators;
    }

    public void setComparators(Map<ComparatorTypes, Comparator<Gadget>> comparators) {
        this.comparators = comparators;
    }

    public boolean addComparator(ComparatorTypes key, Comparator<Gadget> comparator) {
        boolean res = false;
        if (!comparators.containsKey(key)) {
            comparators.put(key, comparator);
            res = true;
        }
        return res;
    }

    public Comparator<Gadget> getComparator(String key) {
        return getComparator(ComparatorTypes.valueOf(key.toUpperCase()));
    }

    public Comparator<Gadget> getComparator(ComparatorTypes key) {
        Comparator<Gadget> comparator = null;
        if (comparators.containsKey(key)) {
            comparator = comparators.get(key);
        }
        return comparator;
    }

    @Override
    public String toString() {
        return Arrays.toString(ComparatorTypes.values());
    }
}
