public class HashSetTest
{
  public static void print(util.Collection<?> c)
  {
    for (util.Iterator<?> i = (util.Iterator<?>) c.iterator(); i.hasNext();)
      System.out.println(i.next());
    System.out.println();
  }

  public static void main(String[] args)
  { 
    /*
    util.HashSet<Integer> s = new util.HashSet<>();

    for (int i = 109; i > 0; i--)
    {
      s.add(i);
      s.add(i);
    }
    s.print();
    print(s);
    */
    util.HashSet<String> s = new util.HashSet<>();

    for (int i = 1099; i > 0; i--)
    {
      s.add("APOOII:" + i);
      s.add("APOOII:" + i);
    }
    s.print();
    print(s);
  }

} // HashSetTest
