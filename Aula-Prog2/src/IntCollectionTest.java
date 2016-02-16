import util.*;

public class IntCollectionTest
{
  private static void test(IntCollection c)
  {
    System.out.printf("**%s test\n", c.getClass().getName());
    for (int i = 1; i < 10; i++)
      c.add(i);
    c.remove(1);
    c.remove(5);
    c.remove(9);
    c.add(0, 10);
    c.add(c.size() / 2, 50);
    c.add(c.size() - 1, 90);
    for (IntIterator i = c.iterator(); i.hasNext();)
      System.out.println(i.next());
    System.out.println();
  }

  public static void main(String[] args)
  {
    test(new IntLinkedList());
    test(new IntArray());
  }

} // IntCollectionTest