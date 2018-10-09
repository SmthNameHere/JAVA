package by.bntu.fitr.povt.javanutie.model.container.utils.comparators;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.Comparator;

public class GadgetPrestigeDescComparator implements Comparator<Gadget> {
    @Override
    public int compare(Gadget t1, Gadget t2) {
        return Double.compare(t2.getPrestige(), t1.getPrestige());
    }
}
