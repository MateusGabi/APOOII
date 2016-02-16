package util;

public interface Collection<E>
  extends Iterable<E>
{
  public void add(E value);
  public void addAll(Collection<? extends E> c);
  public boolean remove(E value);
  public void clear();
  public boolean contains(E value);
  public boolean isEmpty();
  public int size();

} // Collection
