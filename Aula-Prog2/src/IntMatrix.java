public class IntMatrix
{
  private final int m;
  private final int n;
  private final int[] data;

  public IntMatrix(int m, int n)
  {
    this.m = m;
    this.n = n;
    data = new int[m * n];
  }

  public IntMatrix(int m, int n, int[] data)
  {
    this.m = m;
    this.n = n;
    this.data = data;
  }

  public int m()
  {
    return m;
  }

  public int n()
  {
    return n;
  }

  public int size()
  {
    return data.length;
  }

  public int get(int i, int j)
  {
    return data[i * n + j];
  }

  public void put(int i, int j, int value)
  {
    data[i * n + j] = value;
  }

  public IntMatrix add(IntMatrix b)
  {
    int[] c = new int[data.length];

    for (int i = 0; i < data.length; i++)
      c[i] = data[i] + b.data[i];
    return new IntMatrix(m, n, c);
  }

  public IntMatrix sub(IntMatrix b)
  {
    int[] c = new int[data.length];

    for (int i = 0; i < data.length; i++)
      c[i] = data[i] - b.data[i];
    return new IntMatrix(m, n, c);
  }

  public IntMatrix mul(int s)
  {
    int[] c = new int[data.length];

    for (int i = 0; i < data.length; i++)
      c[i] = data[i] * s;
    return new IntMatrix(m, n, c);
  }

  public IntMatrix mul(IntMatrix b)
  {
    int[] c = new int[m * b.n];

    for (int p = 0, r = 0, i = 0; i < m; i++, r += n)
      for (int j = 0; j < b.n; j++)
      {
        int s = 0;

        for (int k = 0; k < n; k++)
          s += data[r + k] * b.get(k, j);
        c[p++] = s;
      }
    return new IntMatrix(m, b.n, c);
  }

  public IntVector mul(IntVector b)
  {
    int[] c = new int[b.size()];

    for (int p = 0, r = 0, i = 0; i < m; i++, r += n)
    {
      int s = 0;

      for (int k = 0; k < n; k++)
        s += data[r + k] * b.get(k);
      c[p++] = s;
    }
    return new IntVector(c);
 }

  public void print(String label)
  {
    System.out.println("**Matrix " + label);
    for (int p = 0, i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++, p++)
        System.out.printf("%d ", data[p]);
      System.out.println();
    }
  }

} // IntMatrix
