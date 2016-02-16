public class BSearchTest
{
  static int bSearch(int[] a, int li, int hi, int value)
  {
    if (li > hi)
      return -1;

    int m = (li + hi) >> 1;
    int c = value - a[m];

    if (c == 0)
      return m;
    if (c < 0)
      hi = m - 1;
    else
      li = m + 1;
    return bSearch(a, li, hi, value);
  }

  static int bSearch2(int[] a, int li, int hi, int value)
  {
    while (li <= hi)
    {
      int m = (li + hi) >> 1;
      int c = value - a[m];

      if (c == 0)
        return m;
      if (c < 0)
        hi = m - 1;
      else
        li = m + 1;
    }
    return -1;
  }

  public static int bSearch(int[] a, int value)
  {
    return bSearch2(a, 0, a.length - 1, value);
  }

  public static void main(String[] args)
  {
    System.out.println(bSearch(new int[] {3}, 3));
    System.out.println(bSearch(new int[] {3, 4}, 3));
    System.out.println(bSearch(new int[] {2, 3}, 3));
    System.out.println(bSearch(new int[] {2, 3, 4}, 3));
    System.out.println(bSearch(new int[] {1, 2, 3}, 3));
    System.out.println(bSearch(new int[] {1, 2, 3, 4}, 3));
  }

} // BSearchTest
