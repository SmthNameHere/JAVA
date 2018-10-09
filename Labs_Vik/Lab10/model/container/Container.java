package by.bntu.fitr.povt.javanutie.model.container;

public interface Container<E> {
    boolean isEmpty();
    int size();
    E get(int index);
    void set(int index, E element);
    void add(E element);
    void addAll(E[] elements);
    E deleteElement(int index);
    Object[] toArray();
    void clear();
}
