import util.*;

public class IntArrayTest
{
  public static void main(String[] args)
  {
    int[] d = { 5, 3, 1, 9, 2, 7, 8, 9, 4, 6 };
    IntArraySortedSet a = new IntArraySortedSet();

    for (int i = 0; i < d.length; i++)
      a.add(d[i]);
    print("a", a);
  }

  static void print(String label, IntArraySortedSet a)
  {
    System.out.printf("**Array %s\n", label);
    for (int n = a.size(), i = 0; i < n; i++)
      System.out.println(a.get(i));
  }

} // IntArrayTest
