package GradeBook.dataStructures;

import GradeBook.interfaces.MyCollectionInterface;

import java.util.Arrays;

public class List<T> implements MyCollectionInterface<T> {

    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private Object elements[];

    /**
     * Constructor
     */
    public List() {
        elements = new Object[DEFAULT_CAPACITY];
    }


    @Override
    public boolean add(T newItem) {
        boolean itemAdded = false;
        if (size == elements.length) {
            ensureCapacity();
        }

        if (newItem != null) {
            elements[size++] = newItem;
            itemAdded = true;
        }
        return itemAdded;
    }


    private void ensureCapacity() {

        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }


    @Override
    public T remove() {
        Object removedItem = null;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                removedItem = elements[i];
                elements[i] = null;
                size--;
                break;
            }
        }
        return (T) removedItem;
    }


    @Override
    public boolean remove(T anEntry) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(anEntry)) {
                elements[i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int getCurrentSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (Object obj : elements) {
            if (obj != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;

        for (Object obj : elements) {
            if (obj.equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {

        for (int i = 0; i < size; i++) {
            if (anEntry.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[size];
        int index = 0;

        for (Object item : elements) {
            if (item != null) {
                returnArray[index] = item;
                index++;
            }
        }

        return returnArray;
    }
}
