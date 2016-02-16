package util;

class ForwardLinkedListIterator<E>
  implements ListIterator<E>
{
  ForwardLinkedListIterator(ForwardLinkedList.Node<E> node)
  {
    current = node;
  }

  @Override
  public boolean hasNext()
  {
    return current != null;
  }

  @Override
  public E next()
  {
    E value = current.value;
  
    current = current.next;
    return value;
  }

  @Override
  public boolean hasPrevious()
  {
    throw new UnsupportedOperationException("Not supported.");    
  }

  @Override
  public E previous()
  {
    throw new UnsupportedOperationException("Not supported.");    
  }

  private ForwardLinkedList.Node<E> current;

} // ForwardLinkedListIterator

public class ForwardLinkedList<E>
  extends AbstractList<E>
{
  @Override
  public void add(int index, E value)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();

    Node<E> prev = null;
    Node<E> next = head;

    for (int i = 0; i < index; i++)
    {
      prev = next;
      next = next.next;
    }

    Node<E> node = new Node<>(value);

    node.next = next;
    if (next == head)
      head = node;
    else
      prev.next = node;
    ++count;
  }

  public void addFirst(E value)
  {
    Node<E> node = new Node<>(value);

    node.next = head;
    head = node;
    ++count;
  }

  public void addLast(E value)
  {
    Node<E> node = new Node<>(value);

    if (head == null)
      head = node;
    else
      tail.next = node;
    tail = node;
    ++count;
  }

  @Override
  public boolean remove(E value)
  {
    for (Node<E> prev = null, node = head; node != null; node = node.next)
    {
      if (!value.equals(node.value))
      {
        prev = node;
        continue;
      }
      if (node == head)
        head = node.next;
      else
        prev.next = node.next;
      if (node == tail)
        tail = prev;
      --count;
      return true;
    }
    return false;
  }

  @Override
  public void clear()
  {
    head = tail = null;
    count = 0;
  }

  @Override
  public boolean isEmpty()
  {
    return head == null;
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

    Node<E> node = head;

    for (int i = 0; i < index; i++)
      node = node.next;
    return node.value;
  }

  @Override
  public void set(int index, E value)
  {
    if (index < 0 || index >= count)
      throw new IndexOutOfBoundsException();

    Node<E> node = head;

    for (int i = 0; i < index; i++)
      node = node.next;
    node.value = value;
  }

  @Override
  public Iterator<E> iterator()
  {
    return new ForwardLinkedListIterator<>(head);
  }

  @Override
  public ListIterator<E> listIterator()
  {
    return new ForwardLinkedListIterator<>(head);
  }

  @Override
  public int indexOf(Object value)
  {
    int index = 0;

    for (Node<E> node = head; node != null; node = node.next, ++index)
      if (node.value.equals(value))
        return index;
    return -1;
  }

  static class Node<E>
  {
    E value;
    Node next;

    Node(E value)
    {
      this.value = value;
    }

  } // Node

  private Node<E> head;
  private Node<E> tail;
  private int count;

} // LinkedList