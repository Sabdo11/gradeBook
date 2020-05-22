package GradeBook.dataStructures;

import GradeBook.interfaces.MyCollectionInterfaceProject04;

public class MyLinkedList<T> implements MyCollectionInterfaceProject04<T> {
    private Node head;
    private int size;

    public MyLinkedList() {
        head = new Node(null);
        size = 0;
    }

    @Override
    public boolean add(T newItem) {
        Node newNode = new Node(newItem);
        Node currentNode = head;
        boolean isAdded = false;
        if (isEmpty()) {
            head = newNode;
            size++;
            isAdded = true;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            size++;
            isAdded = true;
        }
        return isAdded;
    }


    @Override
    public boolean add(T newItem, int position) {
        Node newNode = new Node(newItem);
        Node currentNode = head;
        boolean isAdded = false;

        // Let's check for NPE before iterate over Current
        if (currentNode != null) {
            // crawl to the requested index or the last element in the list, whichever comes first
            for (int i = 0; i < position && currentNode.getNextNode() != null; i++) {
                currentNode = currentNode.getNextNode();
            }
        }

        if (currentNode == null) {
            head = newNode;
            size++;
            isAdded = true;

        } else {
            newNode.setNextNode(currentNode.getNextNode());
            // now set this node's next-node reference to the new node
            currentNode.setNextNode(newNode);

            // increment the number of elements variable
            size++;
            isAdded = true;

        }


        return isAdded;
    }

    @Override
    public boolean remove(T anEntry) {
        // Store head node
        Node current = head, next = null;

        // If head node itself holds the key to be deleted
        if (current != null && anEntry.equals(current.getData())) {
            head = current.getNextNode(); // Changed head
            return true;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (current != null && !anEntry.equals(current.getData())) {
            next = current;
            current = current.getNextNode();
        }

        // If key was not present in linked list
        if (current == null) {
            return false;
        }

        // Unlink the node from linked list
        next.setNextNode(current.getNextNode());

        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty;
        if (size == 0 && head == null){
            isEmpty = true;
        }
        else {
            isEmpty = false;
        }

        return isEmpty;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        Node current = head;
        int frequency = 0;
        while (current != null) {
            if (anEntry.equals(current.getData())) {
                frequency++;
            }
            current = current.getNextNode();
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        Node current = head;
        while (current != null) {
            if (anEntry.equals(current.getData())) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node current = head;
        while ((index < size) && (current != null)) {
            array[index] = current.getData();
            current = current.getNextNode();
            index++;
        }

        return array;
    }

}
