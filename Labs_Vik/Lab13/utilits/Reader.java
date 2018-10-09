package by.bntu.fitr.povt.javanutie.utilits;

import by.bntu.fitr.povt.javanutie.controller.Game;
import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

public interface Reader {
    void read(String filename, Container<Gadget> container);
    void write(String filename, Container<Gadget> container);
}
