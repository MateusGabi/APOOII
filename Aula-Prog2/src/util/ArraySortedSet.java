package util;

public class ArraySortedSet<E>
  extends ArraySet<E>
  implements SortedSet<E>
{
  public ArraySortedSet()
  {
    // do nothing
  }

  public ArraySortedSet(Comparator<E> comparator)
  {
    this.comparator = comparator;
  }

  @Override
  public void add(E value)
  {
    int index = 0;

    for (; index < size; index++)
    {
      int cmp = compare((E)data[index], value);

      if (cmp == 0)
        return;
      else if (cmp > 0)
        break;
    }
    if (size == data.length)
      resize();
    for (int i = size; i > index; i--)
      data[i] = data[i - 1];
    data[index] = value;
    size++;
  }

  private Comparator<E> comparator;

  private int compare(E o1, E o2)
  {
    if (comparator != null)
      return comparator.compare(o1, o2);
    return ((Comparable<E>)o1).compareTo(o2);
  }

} // ArraySortedSet
