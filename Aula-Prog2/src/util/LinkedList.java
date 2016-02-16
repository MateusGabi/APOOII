package util;

class LinkedListIterator<E>
  implements ListIterator<E>
{
  LinkedListIterator(LinkedList.Node<E> dummy)
  {
    this.dummy = dummy;
    current = dummy.next;
  }

  @Override
  public boolean hasNext()
  {
    return current != dummy;
  }

  @Override
  public E next()
  {
    LinkedList.Node<E> temp = current;

    current = current.next;
    return temp.value;
  }

  @Override
  public boolean hasPrevious()
  {
    return current.prev != dummy;
  }

  @Override
  public E previous()
  {
    return (current = current.prev).value;
  }

  private final LinkedList.Node<E> dummy;
  private LinkedList.Node<E> current;

} // LinkedListIterator

public class LinkedList<E>
  extends AbstractList<E>
{
  public LinkedList()
  {
    dummy = new Node<>(null);
    dummy.next = dummy.prev = dummy;
  }

  @Override
  public void add(int index, E value)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();

    Node<E> next = dummy.next;

    for (int i = 0; i < index; i++)
      next = next.next;
    addBefore(next, value);
  }

  public void addFirst(E value)
  {
    addBefore(dummy.next, value);
  }

  public void addLast(E value)
  {
    addBefore(dummy, value);
  }

  @Override
  public boolean remove(E value)
  {
    for (Node<E> node = dummy.next; node != dummy; node = node.next)
      if (value.equals(node.value))
      {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        --count;
        return true;
      }
    return false;
  }

  @Override
  public void clear()
  {
    dummy.next = dummy.prev = dummy;
    count = 0;
  }

  @Override
  public boolean isEmpty()
  {
    return dummy.next == dummy;
  }

  @Override
  public int size()
  {
    return count;
  }

  @Override
  public E get(int index)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();
 
    Node<E> node = dummy.next;

    for (int i = 0; i < index; i++)
      node = node.next;
    return node.value;
  }

  @Override
  public void set(int index, E value)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();
 
    Node<E> node = dummy.next;

    for (int i = 0; i < index; i++)
      node = node.next;
    node.value = value;
  }

  @Override
  public int indexOf(Object value)
  {
    int index = 0;

    for (Node<E> node = dummy.next; node != dummy; node = node.next, ++index)
      if (node.value.equals(value))
        return index;
    return -1;
  }

  @Override
  public Iterator<E> iterator()
  {
    return new LinkedListIterator<>(dummy);
  }

  @Override
  public ListIterator<E> listIterator()
  {
    return new LinkedListIterator<>(dummy);
  }

  static class Node<E>
  {
    E value;
    Node<E> next;
    Node<E> prev;

    Node(E value)
    {
      this.value = value;
    }

  } // Node

  private final Node<E> dummy;
  private int count;

  private void addBefore(Node<E> next, E value)
  {
    Node<E> node = new Node<>(value);

    next.prev.next = node;
    node.prev = next.prev;
    next.prev = node;
    node.next = next;
    ++count;    
  }

} // LinkedList