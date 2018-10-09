package by.bntu.fitr.povt.javanutie.model.container;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.*;

public enum ContainersCreator {
    CONTAINERS_CREATOR;

    public enum ContainerType {
        LIST_BY_ARRAY,
        LIST_BY_ELEMENTS;
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
