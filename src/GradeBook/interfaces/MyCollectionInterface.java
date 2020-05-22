package GradeBook.interfaces;

/**
 * An interface that describes all the operations to be implemented in a
 * collection class. It uses generic object (T) and can be used to implement a
 * collection class to store generic objects.
 * @author Dr. Salim Lakhani
 * @version 1.1, 2017, February 7
 */
public interface MyCollectionInterface<T> {

    /**
     * Adds a new entry to this collection
     *
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */
    public boolean add (T newItem);

    //************************************************************************

    /**
     * Removes one unspecified entry from the collection, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    public T remove ();

    //************************************************************************

    /**
     * Removes one occurrence of a given entry from this collection.
     *
     * @param anEntry The entry to be removed.
     * @return true if the removal was successful, false if not.
     */
    public boolean remove (T anEntry);

    //************************************************************************

    /**
     * Removes all entries from this collection.
     */
    public void clear();

    //************************************************************************

    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */
    public int getCurrentSize();

    //************************************************************************

    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */
    public boolean isEmpty();

    //************************************************************************

    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */
    public int getFrequencyOf(T anEntry);

    //************************************************************************

    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */
    public boolean contains (T anEntry);

    //************************************************************************

    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection.
     * Note: If the collection is empty, the returned array is empty.
     */
    public Object[] toArray ();

}