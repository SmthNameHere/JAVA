package javanutie.model.container;

import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BasketTest {
    private Gadget[] gadgets;

    @Before
    public void init() {
        Creator creator = Creator.CREATOR;
        gadgets = new Gadget[]{
                creator.createPowerbank(),
                creator.createPhone(),
                creator.createPhone(12, 3, "cpu", 4),
                creator.createPhone(),
                creator.createPowerbank(2, 3, Powerbank.Color.BLACK, 300)
        };
    }

    @Test
    public void add() {
        Basket expected = new Basket(Arrays.copyOf(gadgets, gadgets.length));
        Basket actual = new Basket();
        for (int i = 0 ; i < gadgets.length; i++) {
            actual.add(gadgets[i]);
        }
        assertEquals(expected, actual);
    }

    @Test
    public void delete() {
        Gadget delGadget = gadgets[gadgets.length - 1];
        Basket expected = new Basket(Arrays.copyOf(gadgets, gadgets.length - 1));

        Basket actual = new Basket(Arrays.copyOf(gadgets, gadgets.length));
        actual.delete(delGadget);
        assertEquals(expected, actual);
    }
}