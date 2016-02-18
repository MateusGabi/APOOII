package util;

class IntNode
{
  int value;
  IntNode next;

  IntNode(int value)
  {
    this.value = value;
  }

} // IntNode

class IntLinkedListIterator
  extends IntIterator
{
  private IntNode current;

  IntLinkedListIterator(IntNode node)
  {
    current = node;
  }

  @Override
  public boolean hasNext()
  {
    return current != null;
  }

  @Override
  public int next()
  {
    int value = current.value;
  
    current = current.next;
    return value;
  }

} // IntLinkedListIterator

class IntLinkedList
  extends IntCollection
{
  private IntNode head;
  private IntNode tail;
  private int count;

  @Override
  public void add(int value)
  {
    addAtTail(value);
  }

  @Override
  public void add(int index, int value)
  {
    // if (index < 0 || index >= count)
    //   TODO
    IntNode prev = null;
    IntNode next = head;

    for (int i = 0; i < index; i++)
    {
      prev = next;
      next = next.next;
    }

    IntNode node = new IntNode(value);

    node.next = next;
    if (next == head)
      head = node;
    else
      prev.next = node;
    ++count;
  }

  public void addAtHead(int value)
  {
    IntNode node = new IntNode(value);

    node.next = head;
    head = node;
    ++count;
  }

  public void addAtTail(int value)
  {
    IntNode node = new IntNode(value);

    if (head == null)
      head = node;
    else
      tail.next = node;
    tail = node;
    ++count;
  }

  @Override
  public boolean remove(int value)
  {
    for (IntNode prev = null, node = head; node != null; node = node.next)
    {
      if (value != node.value)
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
  public boolean contains(int value)
  {
    for (IntNode node = head; node != null; node = node.next)
      if (node.value == value)
        return true;
    return false;
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
  public int get(int index)
  {
    // if (index < 0 || index >= count)
    //   TODO
    IntNode node = head;

    for (int i = 0; i < index; i++)
      node = node.next;
    return node.value;
  }

  @Override
  public void set(int index, int value)
  {
    // if (index < 0 || index >= count)
    //   TODO
    IntNode node = head;

    for (int i = 0; i < index; i++)
      node = node.next;
    node.value = value;
  }

  @Override
  public IntIterator iterator()
  {
    return new IntLinkedListIterator(head);
  }

} // IntLinkedList