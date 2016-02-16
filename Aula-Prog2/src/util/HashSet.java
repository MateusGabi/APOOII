package util;

public class HashSet<E>
  implements Set<E>
{
  public static int MAX_TABLE_SIZE = 256;

  public HashSet()
  {
    initTable(32);
  }

  private void initTable(int size)
  {
    table = new Entry[size];
    for (int i = 0; i < size; i++)
    {
      Entry e = new Entry(null);
    
      e.next = e.prev = e;
      table[i] = e;
    }
  }

  private void addEntry(int i, Object value)
  {
    Entry s = table[i];
    Entry e = new Entry(value);

    e.prev = s;
    e.next = s.next;
    s.next.prev = e;
    s.next = e;    
  }

  private void resize()
  {
    Entry[] temp = table;

    initTable(size);
    for (Entry s : temp)
      for (Entry e = s.next; e != s; e = e.next)
        addEntry(index(e.value), e.value);
  }

  @Override
  public void add(E value)
  {
    int i = index(value);
 
    if (findEntry(i, value) != null)
      return;
    if (size == (table.length << 1) && size <= MAX_TABLE_SIZE)
    {
      resize();
      i = index(value);
    }
    addEntry(i, value);
    ++size;
  }

  @Override
  public void addAll(Collection<? extends E> c)
  {
    for (Iterator<? extends E> i = c.iterator(); i.hasNext();)
      add(i.next());
  }

  @Override
  public boolean remove(E value)
  {
    int i = index(value);
    Entry e = findEntry(i, value);

    if (e == null)
      return false;
    e.next.prev = e.prev;
    e.prev.next = e.next;
    --size;
    return true;
  }

  @Override
  public void clear()
  {
    for (Entry e : table)
      e.next = e.prev = e;
    size = 0;
  }

  @Override
  public boolean contains(E value)
  {
    return findEntry(index(value), value) != null;
  }

  @Override
  public boolean isEmpty()
  {
    return size == 0;
  }

  @Override
  public int size()
  {
    return size;
  }

  @Override
  public Iterator<E> iterator()
  {
    return new HashSetIterator<>(table);
  }

  public void print()
  {
    for (int i = 0; i < table.length; i++)
    {
      Entry s = table[i];

      for (Entry e = s.next; e != s; e = e.next)
        System.out.println(String.valueOf(i) + ":" +  e.value);
    }
  }

  static class Entry
  {
    Object value;
    Entry next;
    Entry prev;
    
    Entry(Object value)
    {
      this.value = value;
    }

  } // Entry

  private Entry[] table;
  private int size;

  private Entry findEntry(int i, E value)
  {
    Entry s = table[i];

    for (Entry e = s.next; e != s; e = e.next)
      if (value.equals(e.value))
        return e;
    return null;
  }

  private int index(Object value)
  {
    return Math.abs(value.hashCode()) % (table.length - 1);
  }

} // HashSet

class HashSetIterator<E>
  implements Iterator<E>
{
  HashSetIterator(HashSet.Entry[] table)
  {
    this.table = table;
    index = -1;
    hasNextEntry();
  }

  private boolean hasNextEntry()
  {
    while (++index < table.length)
    {
      current = table[index].next;
      if (current != table[index])
        return true;
    }
    return false;
  }

  @Override
  public boolean hasNext()
  {
    if (index < table.length && current != table[index])
      return true;
    return hasNextEntry();
  }

  @Override
  public E next()
  {
    E value = (E)current.value;

    current = current.next;
    return value;
  }

  private final HashSet.Entry[] table;
  int index;
  HashSet.Entry current;

} // HashTestIterator
