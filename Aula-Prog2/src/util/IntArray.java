package util;

public class IntArray
  extends IntCollection
{
  public IntArray()
  {
    data = new int[10];
  }

  @Override
  public void add(int value)
  {
    if (size == data.length)
      resize();
    data[size++] = value;
  }

  @Override
  public void add(int index, int value)
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

  @Override
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

  @Override
  public void clear()
  {
    size = 0;
  }

  @Override
  public boolean contains(int value)
  {
    return find(value) != -1;
  }

  @Override
  public int get(int index)
  {
    // if (index < 0 || index >= size)
    // TODO
    return data[index];
  }

  @Override
  public void set(int index, int value)
  {
    // if (index < 0 || index >= size)
    // TODO
    data[index] = value;
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
  public IntIterator iterator()
  {
    return new IntArrayIterator(this);
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

} // IntArray

class IntArrayIterator
  extends IntIterator
{
  private IntArray array;
  private int index;

  IntArrayIterator(IntArray a)
  {
    array = a;
    index = 0;
  }

  @Override
  public boolean hasNext()
  {
    return index < array.size();
  }

  @Override
  public int next()
  {
    return array.get(index++);
  }
  
} // IntArrayIterator
