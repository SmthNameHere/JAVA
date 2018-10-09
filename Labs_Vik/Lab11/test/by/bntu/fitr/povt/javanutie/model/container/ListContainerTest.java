package by.bntu.fitr.povt.javanutie.model.container;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;
import by.bntu.fitr.povt.javanutie.model.utils.Creator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListContainerTest {
    private Creator creator;
    private Gadget[] gadgets;

    {
        creator = Creator.CREATOR;
    }

    @Before
    public void init() {
        gadgets = new Gadget[] {
                creator.createPhone(),
                creator.createPowerbank(16, 4.5, Powerbank.Color.BLACK, 0),
                creator.createPhone(90, 2.5, "", 0),
                creator.createPhone(12, 3, "", 0),
                creator.createPhone(88, 5, "", 0),
                creator.createPowerbank(2, 3, Powerbank.Color.BLACK, 0)
        };
    }

    @Test
    public void add() {
        ListContainer<Gadget> list = new ListContainer<>();
        for(Gadget gadget : gadgets) {
            list.add(gadget);
        }
        ListContainer<Gadget> actual = new ListContainer<>();
        actual.addAll(gadgets);

        assertEquals(list, actual);
    }

    @Test
    public void deleteElement() {
        ListContainer<Gadget> actual = new ListContainer<>();
        actual.addAll(gadgets);
        actual.deleteElement(actual.size() - 1);

        ListContainer<Gadget> expected = new ListContainer<>();
        expected.addAll(Arrays.copyOf(gadgets, gadgets.length - 1));
        assertEquals(expected, actual);
    }

    @Test
    public void toArray() {
        ListContainer<Gadget> list = new ListContainer<>();
        list.addAll(gadgets);
        Object[] actual = list.toArray();

        assertArrayEquals(gadgets, actual);
    }

    @Test
    public void size() {
        ListContainer<Gadget> list = new ListContainer<>();
        list.addAll(gadgets);
        list.deleteElement(gadgets.length - 1);
        int actual = list.size();
        int expected = gadgets.length - 1;

        assertEquals(expected, actual);
    }
}