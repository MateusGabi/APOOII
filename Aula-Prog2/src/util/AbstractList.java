package util;

public abstract class AbstractList<E>
  implements List<E>
{
  @Override
  public void add(E value)
  {
    addLast(value);
  }

  @Override
  public void addAll(Collection<? extends E> c)
  {
    for (Iterator<? extends E> i = c.iterator(); i.hasNext();)
      add(i.next());
  }

  @Override
  public boolean contains(E value)
  {
    return indexOf(value) != -1;
  }

  public abstract void addFirst(E value);
  public abstract void addLast(E value);

} // AbstractList
