package by.bntu.fitr.povt.javanutie.model.entity;

import java.util.Objects;

public class Phone extends Gadget {
    private static final String DEFAULT_CPU = "snapdragon";
    private static final double DEFAULT_DIAGONAL = 4.0;

    private String cpu;
    private double diagonal;

    public Phone() {
        super();
        cpu = DEFAULT_CPU;
        diagonal = DEFAULT_DIAGONAL;
    }

    public Phone(String cpu, double diagonal) {
        super();
        this.cpu = cpu;
        this.diagonal = diagonal;
    }

    public Phone(double price, double prestige, String cpu, double diagonal) {
        super(price, prestige);
        this.cpu = cpu;
        this.diagonal = diagonal;
    }

    public Phone(Phone other) {
        super(other);
        cpu = other.cpu;
        diagonal = other.diagonal;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
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
        Phone phone = (Phone) o;
        return Double.compare(phone.diagonal, diagonal) == 0 &&
                Objects.equals(cpu, phone.cpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpu, diagonal);
    }

    @Override
    public String toString() {
        return String.format("Phone (%2.1f dm, %s) - %.2f coins, rating of thing - %.2f",
                diagonal,
                cpu,
                getPrice(),
                getPrestige());
    }
}
