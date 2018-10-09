package by.bntu.fitr.povt.javanutie.model.container;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;

import java.util.*;

public class Basket<E> extends BasicContainer<E> {
    private List<E> list;

    public Basket() {
        list = new ArrayList<>();
    }

    public Basket(List<E> list) {
        this.list = list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E get(int index) {
        E get = null;
        if (index >= 0 && index < list.size()) {
            get = list.get(index);
        }
        return get;
    }

    @Override
    public void set(int index, E element) {
        if(index >= 0 && index < list.size()) {
            list.set(index, element);
        }
    }

    @Override
    public void add(E element) {
        list.add(element);
    }

    @Override
    public void addAll(E[] elements) {
        list.addAll(Arrays.asList(elements));
    }

    @Override
    public E deleteElement(int index) {
        E del = null;
        if (index >= 0 && index < list.size()) {
            del = list.remove(index);
        }
        return del;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(E element : list) {
            string.append(element.toString()).append("\n");
        }
        return string + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket<?> basket = (Basket<?>) o;
        return Objects.equals(list, basket.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
