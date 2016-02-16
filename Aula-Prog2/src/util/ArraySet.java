package util;

public class ArraySet<E>
  extends Array<E>
  implements Set<E>
{
  @Override
  public void add(E value)
  {
    if (indexOf(value) == -1)
      super.add(value);
  }

} // ArraySet
