package by.bntu.fitr.povt.javanutie.model.utils;

import by.bntu.fitr.povt.javanutie.model.entity.Phone;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;

public class Creator {
    public Powerbank createPowerbank() {
        return new Powerbank();
    }

    public Powerbank createPowerbank(double price,
                                            double prestige,
                                            String color,
                                            int capacity) {
        return new Powerbank(price, prestige, color, capacity);
    }

    public Phone createPhone() {
        return new Phone();
    }

    public Phone createPhone(double price,
                                    double prestige,
                                    String cpu,
                                    double diagonal) {
        return new Phone(price, prestige, cpu, diagonal);
    }
}
