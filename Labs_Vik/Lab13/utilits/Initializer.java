package by.bntu.fitr.povt.javanutie.utilits;

import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.Arrays;

public enum Initializer {
    FROM_BINARY_FILE(new BinaryReaderWriterGameRoom()),
    FROM_TEXT_FILE(new TextReaderWriterGameRoom());

    private Reader init;

    Initializer(Reader init) {
        this.init = init;
    }

    public void write(String filename, Container<Gadget> container) {
        init.write(filename, container);
    }

    public void read(String filename, Container<Gadget> container) {
        init.read(filename, container);
    }
}

