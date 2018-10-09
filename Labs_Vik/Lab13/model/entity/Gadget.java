package by.bntu.fitr.povt.javanutie.model.entity;

import java.util.Objects;

public abstract class Gadget implements Comparable<Gadget> {

    private static final double DEFAULT_PRICE = 0.0;
    private static final double DEFAULT_PRESTIGE = 0.0;
    private double price;
    private double prestige;

    public Gadget() {
        price = DEFAULT_PRICE;
        prestige = DEFAULT_PRESTIGE;
    }

    public Gadget(double price, double prestige) {
        this.price = price;
        this.prestige = prestige;
    }

    public Gadget(Gadget other) {
        price = other.price;
        prestige = other.prestige;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrestige() {
        return prestige;
    }

    public void setPrestige(double prestige) {
        this.prestige = prestige;
    }

    @Override
    public String toString() {
        return String.format("Gadget has price (%.2f) and prestige (%.2f)",
                price,
                prestige);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Gadget)) {
            return false;
        }
        Gadget gadget = (Gadget) o;
        return Double.compare(gadget.price, price) == 0 &&
                Double.compare(gadget.prestige, prestige) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, prestige);
    }

    @Override
    public int compareTo(Gadget gadget) {
        return Double.compare(price, gadget.price);
    }
}
