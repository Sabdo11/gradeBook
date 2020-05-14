package com.selam.gradeBook.domain.interfaces;

/**
 * An interface that describes all the operations to be implemented in a
 * collection class. It usMyCollectionInterfaceProjectes generic object (T) and can be used to implement a
 * collection class to store generic objects.
 * @author Dr. Salim Lakhani, Peter Nielson, David Kramer
 * @version 1.2 2019-06-04
 */

public interface MyCollectionInterfaceProject04<T> {

    /**
     * Adds a new entry to this collection
     *
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
    public boolean add (T newItem);

    /**
     * Adds a new entry to this collection at the given position
     *
     * @param newItem The object to be added to the collection
     * @param position The location where newItem will be inserted.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add (T newItem, int position);

    /**
     * Removes one occurrence of a given entry from this collection.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove (T anEntry);

    /**
     * Removes all entries from this collection.
     */
    public void clear();


    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
    public int getCurrentSize();


    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
    public boolean isEmpty();

    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
    public int getFrequencyOf(T anEntry);

    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
    public boolean contains (T anEntry);

    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection.
     * Note: If the collection is empty, the returned array is empty.
     */
    public Object[] toArray ();

}
