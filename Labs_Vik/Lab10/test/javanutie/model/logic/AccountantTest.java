package javanutie.model.logic;

import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;
import by.bntu.fitr.povt.javanutie.model.logic.Accountant;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class AccountantTest {
    private Container<Gadget> basket;

    @Before
    public void init() {
        Creator creator = Creator.CREATOR;
        basket = new Basket<>();
        basket.addAll(new Gadget[]{
                creator.createPowerbank(16, 4.5, Powerbank.Color.BLACK, 0),
                creator.createPhone(90, 2.5, "", 0),
                creator.createPhone(12, 3, "", 0),
                creator.createPhone(88, 5, "", 0),
                creator.createPowerbank(2, 3, Powerbank.Color.BLACK, 0)
        });
    }

    @Test
    public void calcPrice() {
        double expected = 208;
        double actual = Accountant.calcPrice(basket);
        assertEquals(expected, actual, 4);
    }

    @Test
    public void caclAverageRating() {
        double expected = 3.6;
        double actual = Accountant.caclAverageRating(basket);
        assertEquals(expected, actual, 2);
    }
}