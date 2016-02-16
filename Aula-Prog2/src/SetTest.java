class StringComparator
  implements util.Comparator<String>
{
  @Override
  public int compare(String o1, String o2)
  {
    return o1.compareTo(o2);
  }

} // StringComparator

class MyClass
  implements util.Comparable<MyClass>
{
  MyClass(int a)
  {
    this.a = a;
  }

  @Override
  public int compareTo(MyClass other)
  {
    return a - other.a;
  }

  @Override
  public String toString()
  {
    return String.valueOf(a);
  }

  private int a;

} // MyClass

public class SetTest
{
  public static void print(util.Collection<?> c)
  {
    for (util.Iterator<?> i = c.iterator(); i.hasNext();)
      System.out.println(i.next());
    System.out.println();
  }

  public static void main(String[] args)
  {
    util.Set<String> s = new util.ArraySortedSet<>(new StringComparator());
    util.Set<MyClass> mySet = new util.ArraySortedSet<>();

    for (int i = 9; i > 0; i--)
    {
      s.add("APOOII:" + i);
      s.add("APOOII:" + i);
      mySet.add(new MyClass(i));
    }
    print(s);
    print(mySet);
  }

} // SetTest