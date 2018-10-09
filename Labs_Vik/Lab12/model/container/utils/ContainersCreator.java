package by.bntu.fitr.povt.javanutie.model.container.utils;

import by.bntu.fitr.povt.javanutie.model.container.ArrayContainer;
import by.bntu.fitr.povt.javanutie.model.container.Basket;
import by.bntu.fitr.povt.javanutie.model.container.Container;
import by.bntu.fitr.povt.javanutie.model.container.ListContainer;
import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.*;

public enum ContainersCreator {
    CONTAINERS_CREATOR;

    public enum ContainerType {
        LIST_BY_ARRAY,
        LIST_BY_ELEMENTS,
        LIST_BY_JCF
    }

    public Container<Gadget> getContainer(String type) {
        return getContainer(ContainerType.valueOf(type.toUpperCase()));
    }

    public Container<Gadget> getContainer(ContainerType type) {
        Container<Gadget> container;
        switch (type) {
            case LIST_BY_ARRAY: {
                container = new ArrayContainer<>();
                break;
            }
            case LIST_BY_ELEMENTS: {
                container = new ListContainer<>();
                break;
            }
            case LIST_BY_JCF: {
                container = new Basket<>();
                break;
            }
            default: {
                container = null;
                break;
            }
        }
        return container;
    }

    @Override
    public String toString() {
        return Arrays.toString(ContainerType.values());
    }
}
