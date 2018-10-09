package by.bntu.fitr.povt.javanutie.model.container;

public abstract class BasicContainer<E> implements Container<E> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
