package util;

public abstract class IntCollection
{
  public abstract void add(int value);
  public abstract void add(int index, int value);
  public abstract boolean remove(int value);
  public abstract void clear();
  public abstract boolean contains(int value);
  public abstract int get(int index);
  public abstract void set(int index, int value);
  public abstract boolean isEmpty();
  public abstract int size();
  public abstract IntIterator iterator();

} // IntCollection
