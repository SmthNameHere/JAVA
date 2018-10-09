package by.bntu.fitr.povt.javanutie.model.entity;

import java.util.Objects;

public class Powerbank extends Gadget {

    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final int DEFAULT_CAPACITY = 100;
    private Color color;
    private int capacity;

    public enum Color {
        BLACK,
        BLUE,
        GREEN,
        RED,
        WHITE,
        YELLOW,
        GRAY,
        BROWN,
        ORANGE,
        PURPLE,
        PINK,
        GOLD,
        SILVER,
        BRONZE
    }

    public Powerbank() {
        super();
        color = DEFAULT_COLOR;
        capacity = DEFAULT_CAPACITY;
    }

    public Powerbank(Color color, int capacity) {
        super();
        this.color = color;
        this.capacity = capacity;
    }

    public Powerbank(double price, double prestige, Color color, int capacity) {
        super(price, prestige);
        this.color = color;
        this.capacity = capacity;
    }

    public Powerbank(Powerbank other) {
        super(other);
        color = other.color;
        capacity = other.capacity;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Powerbank powerbank = (Powerbank) o;
        return capacity == powerbank.capacity &&
                Objects.equals(color, powerbank.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, capacity);
    }

    @Override
    public String toString() {
        return String.format("Powerbank (%d mAh, %s) - %.2f coins, rating of thing - %.2f",
                capacity,
                color,
                getPrice(),
                getPrestige());
    }
}
