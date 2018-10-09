package by.bntu.fitr.povt.javanutie.model.container;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayContainer<E> extends BasicContainer<E> {
    private static final int DEFAULT_CAPACITY = 0;
    protected Object[] elements;

    public ArrayContainer() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayContainer(E[] elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public E get(int index) {
        E get = null;
        if (index >= 0 && index < elements.length) {
            get = (E) elements[index];
        }
        return get;
    }

    @Override
    public void set(int index, E element) {
        if (index >= 0 && index < elements.length) {
            elements[index] = element;
        }
    }

    @Override
    public void add(E element) {
        elements = Arrays.copyOf(elements, elements.length + 1);
        elements[elements.length - 1] = element;
    }

    @Override
    public void addAll(E[] addElements) {
        int index = elements.length;
        elements = Arrays.copyOf(elements, elements.length + addElements.length);
        for (int i = 0; index < elements.length; index++, i++) {
            elements[index] = addElements[i];
        }
    }

    @Override
    public E deleteElement(int index) {
        E del = null;
        if (index >= 0 && index < elements.length) {
            Object[] newArray = Arrays.copyOf(elements, elements.length - 1);
            del = (E)elements[index];
            for(; index < newArray.length; index++) {
                newArray[index] = elements[++index];
            }
            elements = newArray;
        }
        return del;
    }

    @Override
    public E[] toArray() {
        return (E[]) elements;
    }

    @Override
    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(Object element : elements) {
            string.append(element.toString()).append("\n");
        }
        return string + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayContainer<?> that = (ArrayContainer<?>) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int curPosition = 0;

            @Override
            public boolean hasNext() {
                return curPosition < size();
            }

            @Override
            public E next() {
                E res;
                if (curPosition < size()) {
                    res = (E) elements[curPosition];
                    curPosition++;
                } else {
                    throw new NoSuchElementException();
                }
                return res;
            }
        };
    }
}
