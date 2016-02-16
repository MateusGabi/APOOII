package util;

public interface List<E>
  extends Collection<E>
{
  public void add(int index, E value);
  public E get(int index);
  public void set(int index, E value);
  public int indexOf(Object value);
  public ListIterator<E> listIterator();

} // List
