package GradeBook.dataStructures;

// @author Frank M. Carrano, Timothy M. Henry
// @version 5.0
// package BagPackage;
public class Node<T>
{
    private T       data;
    private Node<T> next;

    public Node(T dataPortion) // The constructor's name is com.selam.gradeBook.domain.dataStructures.Node, not com.selam.gradeBook.domain.dataStructures.Node<T>
    {
        this(dataPortion, null);
    } // end constructor

//***************************************************************************

    public Node(T dataPortion, Node<T> nextNode)
    {
        data = dataPortion;
        next = nextNode;
    } // end constructor

//***************************************************************************

    public T getData()
    {
        return data;
    } // end getData

//***************************************************************************

    public void setData(T newData)
    {
        data = newData;
    } // end setData

//***************************************************************************

    public Node<T> getNextNode()
    {
        return next;
    } // end getNextNode

//***************************************************************************

    public void setNextNode(Node<T> nextNode)
    {
        next = nextNode;
    } // end setNextNode
}
