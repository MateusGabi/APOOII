package util;

public class IntArraySortedSet
{
  public IntArraySortedSet()
  {
    data = new int[10];
  }

  public void add(int value)
  {
    int i = 0;

    for (; i < size; i++)
      if (data[i] == value)
        return;
      else if (data[i] > value)
        break;
    add(i, value);
  }

  private void add(int index, int value)
  {
    // if (index < 0 || index >= size)
    // TODO
    if (size == data.length)
      resize();
    for (int i = size; i > index; i--)
      data[i] = data[i - 1];
    data[index] = value;
    size++;
  }

  public boolean remove(int value)
  {
    int i = find(value);

    if (i == -1)
      return false;
    while (++i < size)
      data[i - 1] = data[i];
    size--;
    return true;
  }

  public void clear()
  {
    size = 0;
  }

  public boolean contains(int value)
  {
    return find(value) != -1;
  }

  public int get(int index)
  {
    // if (index < 0 || index >= size)
    // TODO
    return data[index];
  }

  public void set(int index, int value)
  {
    // if (index < 0 || index >= size)
    // TODO
    data[index] = value;
  }

  public boolean isEmpty()
  {
    return size == 0;
  }

  public int size()
  {
    return size;
  }

  private int[] data;
  private int size;

  private void resize()
  {
    int[] temp = new int[data.length * 2];

    for (int i = 0; i < data.length; i++)
      temp[i] = data[i];
    data = temp;
  }

  private int find(int value)
  {
    for (int i = 0; i < size; i++)
      if (data[i] == value)
        return i;
    return -1;
  }

} // IntArraySortedSet
