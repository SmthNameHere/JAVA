package by.bntu.fitr.povt.javanutie.model.container;

import by.bntu.fitr.povt.javanutie.model.entity.Gadget;
import by.bntu.fitr.povt.javanutie.model.entity.Phone;
import by.bntu.fitr.povt.javanutie.model.entity.Powerbank;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListContainer<E> extends BasicContainer<E> {
    private Element start;
    private Element end;
    private int size;

    {
        start = null;
        end = null;
        size = 0;
    }

    public ListContainer() {
    }

    private class Element {
        private E element;
        private Element next;
        private Element prev;

        {
            next = null;
            prev = null;
            element = null;
        }

        public Element() {

        }

        public Element(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }

        public Element getPrev() {
            return prev;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return element.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element1 = (Element) o;
            return Objects.equals(element, element1.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        Element current = start;
        E get = null;
        int i = 0;
        while(current != null && i != index) {
            current = current.getNext();
            i++;
        }
        if(current != null) {
            get = current.getElement();
        }
        return get;
    }

    @Override
    public void set(int index, E element) {
        Element current = start;
        int i = 0;
        while(current != null && i != index) {
            current = current.getNext();
            i++;
        }
        if(current != null) {
            current.setElement(element);
        }
    }

    @Override
    public void add(E element) {
        Element add = new Element(element);
        // если список пуст
        if (end == null) {
            start = add;
            end = start;
        // если есть элементы в списке
        } else {
            end.setNext(add);
            add.setPrev(end);
            end = add;
        }
        size++;
    }

    @Override
    public void addAll(E[] elements) {
        Element add;

        // если список был пуст
        if (end == null && elements.length > 0) {
            start = new Element(elements[0]);
            end = start;
        }

        for(int i = 1; i < elements.length; i++) {
            add = new Element(elements[i]);
            end.setNext(add);
            add.setPrev(end);
            end = add;
        }
        size += elements.length;
    }

    @Override
    public E deleteElement(int index) {
        Element current = start;
        E del = null;

        int i = 0;
        while (current != null && i != index) {
            current = current.getNext();
            i++;
        }

        if(current != null) {
            del = current.getElement();
            size--;

            Element prev = current.getPrev();
            Element next = current.getNext();

            if (prev != null && next != null) {
                prev.setNext(next);
                next.setPrev(prev);
            } else if (next != null) {
                start = next;
                next.setPrev(null);
            } else if (prev != null) {
                end = prev;
                prev.setNext(null);
            } else {
                start = null;
                end = null;
            }
        }
        return del;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        Element current = start;
        int i = 0;
        while(current != null && i < objects.length) {
            objects[i] = current.getElement();
            current = current.getNext();
            i++;
        }
        return objects;
    }

    @Override
    public void clear() {
        Element current = start;
        while(current != null) {
            current.setElement(null);
            current = current.getNext();
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Element current = start;
        while(current != null) {
            string.append(current.getElement().toString()).append("\n");
            current = current.getNext();
        }
        return string + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListContainer<E> that = (ListContainer<E>) o;
        boolean flag = true;

        Element current = start;
        Element otherCurrent = that.start;
        while (current != null && otherCurrent != null) {
            if (!current.equals(otherCurrent)) {
                flag = false;
                break;
            }
            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }

        if (flag && (current != null || otherCurrent != null)) {
            flag = false;
        }
        return flag;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Element curElement;

            {
                curElement = start;
            }

            @Override
            public boolean hasNext() {
                return curElement != null;
            }

            @Override
            public E next() {
                E res;
                if (curElement != null) {
                    res = curElement.getElement();
                    curElement = curElement.getNext();
                } else {
                    throw new NoSuchElementException();
                }
                return res;
            }
        };
    }
}
