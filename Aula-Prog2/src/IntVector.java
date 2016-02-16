public class IntVector
{
  private final int[] data;

  public IntVector(int n)
  {
    data = new int[n];
  }

  public IntVector(int[] data)
  {
    this.data = data;
  }

  public int size()
  {
    return data.length;
  }

  public int get(int i)
  {
    return data[i];
  }

  public void put(int i, int value)
  {
    data[i] = value;
  }

  public IntVector add(IntVector b)
  {
    int[] c = new int[data.length];

    for (int i = 0; i < data.length; i++)
      c[i] = data[i] + b.data[i];
    return new IntVector(c);
  }

  public IntVector sub(IntVector b)
  {
    int[] c = new int[data.length];

    for (int i = 0; i < data.length; i++)
      c[i] = data[i] - b.data[i];
    return new IntVector(c);
  }

  public IntVector mul(int s)
  {
    int[] c = new int[data.length];

    for (int i = 0; i < data.length; i++)
      c[i] = data[i] * s;
    return new IntVector(c);
  }

  public void print(String label)
  {
    System.out.println("**Vector " + label);
    for (int d : data)
      System.out.println(d);
  }

} // IntVector
