package util;

import java.util.Iterator;

class ArrayListIterator<E>
  extends ArrayIterator<E>
  implements ListIterator<E>
{
  ArrayListIterator(ArrayList<E> a)
  {
    super(a);
  }

  @Override
  public boolean hasPrevious()
  {
    return index - 1 >= 0;
  }

  @Override
  public E previous()
  {
    return (E)array.data[--index];
  }

} // ArrayListIterator

public class ArrayList<E>
  extends Array<E>
  implements List<E>
{
  @Override
  public void add(int index, E value)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    if (size == data.length)
      resize();
    for (int i = size; i > index; i--)
      data[i] = data[i - 1];
    data[index] = value;
    size++;
  }

  @Override
  public E get(int index)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    return (E)data[index];
  }

  @Override
  public void set(int index, E value)
  {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();
    data[index] = value;
  }
  @Override
  public ListIterator<E> listIterator()
  {
    return new ArrayListIterator(this);
  }

} // ArrayList
