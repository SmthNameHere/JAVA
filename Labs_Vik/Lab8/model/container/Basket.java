package by.bntu.fitr.povt.javanutie.model.container;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.Arrays;

public class Basket {
    private static final int DEFAULT_CAPACITY = 0;
    private Gadget[] gadgets;

    public Basket() {
        gadgets = new Gadget[DEFAULT_CAPACITY];
    }

    public Basket(Gadget[] gadgets) {
        this.gadgets = gadgets;
    }

    public boolean isEmpty() {
        return gadgets.length == 0;
    }

    public int size() {
        return gadgets.length;
    }

    public Gadget get(int index) {
        Gadget get = null;
        if (index >= 0 && index < gadgets.length) {
            get = gadgets[index];
        }
        return get;
    }

    public void set(int index, Gadget gadget) {
        if (index >= 0 && index < gadgets.length) {
            gadgets[index] = gadget;
        }
    }

    public void add(Gadget gadget) {
        gadgets = Arrays.copyOf(gadgets, gadgets.length + 1);
        gadgets[gadgets.length - 1] = gadget;
    }

    public Gadget delete(Gadget gadget) {
        Gadget del = null;
        int index;
        for (index = 0; index < gadgets.length; index++) {
            if (gadget.equals(gadgets[index])) {
                del = gadgets[index];
                break;
            }
        }
        if (index != gadgets.length) {
            Gadget[] nG = Arrays.copyOf(gadgets, gadgets.length - 1);
            for (; index < nG.length; ) {
                nG[index] = gadgets[++index];
            }
            gadgets = nG;
        }
        return del;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Gadget gadget : gadgets) {
            string.append(gadget.toString()).append("\n");
        }
        return string + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        return Arrays.equals(gadgets, basket.gadgets);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(gadgets);
    }
}
