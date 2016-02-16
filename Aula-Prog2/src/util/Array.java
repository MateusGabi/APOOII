package util;

class ArrayIterator<E>
  implements Iterator<E>
{
  ArrayIterator(Array<E> a)
  {
    array = a;
    index = 0;
  }

  @Override
  public boolean hasNext()
  {
    return index < array.size;
  }

  @Override
  public E next()
  {
    return (E)array.data[index++];
  }

  protected Array<E> array;
  protected int index;

} // ArrayIterator

public class Array<E>
  implements Collection<E>
{
  public Array()
  {
    data = new Object[10];
  }

  @Override
  public void add(E value)
  {
    if (size == data.length)
      resize();
    data[size++] = value;
  }

  @Override
  public void addAll(Collection<? extends E> c)
  {
    for (util.Iterator<? extends E> i = (util.Iterator<? extends E>) c.iterator(); i.hasNext();)
      add(i.next());
  }

  public int indexOf(Object value)
  {
    for (int i = 0; i < size; i++)
      if (data[i].equals(value))
        return i;
    return -1;
  }

  @Override
  public boolean remove(E value)
  {
    int i = indexOf(value);

    if (i == -1)
      return false;
    while (++i < size)
      data[i - 1] = data[i];
    size--;
    return true;
  }

  @Override
  public void clear()
  {
    size = 0;
  }

  @Override
  public boolean contains(E value)
  {
    return indexOf(value) != -1;
  }

  @Override
  public int size()
  {
    return size;
  }

  @Override
  public boolean isEmpty()
  {
    return size == 0;
  }

  protected Object[] data;
  protected int size;

  protected void resize()
  {
    Object[] temp = new Object[data.length * 2];

    System.arraycopy(data, 0, temp, 0, data.length);
    data = temp;
  }

    @Override
    public util.Iterator<E> iterator() {
        return new ArrayIterator<>(this);
    }

} // Array
